package minishop.shop.repository;

import minishop.shop.model.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderRepository implements OrderRepositoryIntf{

    private final Connection connection; //prosthesa final

    private final Properties dbProperties;



    public OrderRepository(Connection connection, Properties dbProperties) {
        this.connection = connection;
        this.dbProperties = dbProperties;

    }

    public Order getOrder(int orderId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.008") + orderId;
        ResultSet rs = statement.executeQuery(sql);
        Order Order = null;
        while(rs.next()){
            int customerId = rs.getInt("customer_id");
            int productId = rs.getInt("product_id");
            String paymentMethod = rs.getString("payment_method");
            double totalPrice = rs.getDouble("total");
            Order = new Order(orderId, customerId, productId, paymentMethod);
            Order.setOrderTotal(totalPrice);
        }
        rs.close();
        return Order;
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> allOrders = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.009");
        ResultSet rs = statement.executeQuery(sql);
        Order Order;
        while(rs.next()){
            int orderId = rs.getInt("order_id");
            int customerId = rs.getInt("customer_id");
            int productId = rs.getInt("product_id");
            String paymentMethod = rs.getString("payment_method");
            double totalPrice = rs.getDouble("total");
            Order = new Order(orderId, customerId, productId, paymentMethod);
            Order.setTotalPrice(totalPrice);
            allOrders.add(Order);
        }
        rs.close();
        return allOrders;
    }


    public void updateOrder(int orderId, int customerId, int productId, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,orderId);
        statement.setInt(2, customerId);
        statement.setInt(3, productId);
        statement.executeUpdate();

    }

    public void deleteOrder(int orderId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("delete.into.002")+ orderId;
        statement.executeUpdate(sql);

    }


    public Order createOrder(int orderId, int customerId, int productId, String paymentMethod) throws SQLException {
        String sql =  dbProperties.getProperty("insert.into.003");
        String categoryType = getCustomerCategory(customerId);
        double customerRate = getCustomerDiscount(categoryType);
        double finalCost = finalCost(productId, customerRate);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, orderId);
        statement.setInt(2, customerId);
        statement.setInt(3, productId);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = now.format(format);
        statement.setDouble(4, finalCost);
        statement.setString(5, dateTime);
        statement.setString(6, paymentMethod);

        statement.executeUpdate();


        Order order =  new Order(orderId, customerId, productId, paymentMethod);
        order.setOrderTotal(finalCost);

        return order;
    }

    public double getCustomerDiscount(String categoryType){
        double rate = 0.0;
        switch (categoryType) {
            case "Individual":
            case "Business":
                rate = 0.8;
                break;
            case "Goverment":
                rate = 0.5;
            default:
                break;
        }
        return rate;
    }

    public String getCustomerCategory(int customerId) throws SQLException {
        String categoryType = null;
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.010")+ customerId;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            categoryType = rs.getString("category");
        }
        return categoryType;
    }

    public double finalCost(int productId, double priceRate) throws SQLException {
        double price = 0.0;
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.011")+productId;
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            price = rs.getDouble("price");
        }
        return price*priceRate;
    }

    public String queryTable(String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        String appender = "";
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                    appender+=",  ";
                };
                String columnValue = rs.getString(i);
                System.out.print( rsmd.getColumnName(i) + ": "+ columnValue);
                appender+=rsmd.getColumnName(i) + ": "+ columnValue;

        }
            appender+="\n";
            System.out.println("");
    }
        return appender;
}

    public String queryTableCustomer(String sql, int customerId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, customerId);
        ResultSet rs = statement.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        String appender = "";
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                    appender+=",  ";
                };
                String columnValue = rs.getString(i);
                System.out.print( rsmd.getColumnName(i) + ": "+ columnValue);
                appender+=rsmd.getColumnName(i) + ": "+ columnValue;

            }
            appender+="\n";
            System.out.println("");
        }
        return appender;
    }
}
