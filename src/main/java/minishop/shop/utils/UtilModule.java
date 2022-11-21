package minishop.shop.utils;


import minishop.shop.business.RunService;
import minishop.shop.model.Customer;
import minishop.shop.model.Order;
import minishop.shop.model.Product;
import minishop.shop.service.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UtilModule {


    public static void saveAllCustomersToFile(List<Customer> allCustomers) throws FileNotFoundException {
        FileService fs = new FileService("data\\all_customers.csv");
        fs.saveAllCustomers(allCustomers);
    }

    public static void saveAllProductsToFile(List<Product> allProducts) throws FileNotFoundException {
        FileService fs = new FileService("data\\all_products.csv");
        fs.saveAllProducts(allProducts);
    }

    public static void saveAllOrdersToFile(List<Order> allOrders) throws FileNotFoundException {
        FileService fs = new FileService("data\\all_orders.csv");
        fs.saveAllOrders(allOrders);
    }

    public static String queryTable(Connection connection, Properties dbProperties, String sql) throws SQLException {
        OrderService ar = new OrderService(connection, dbProperties);
        return ar.queryTable(sql);
    }

    public static String queryTableCustomer(Connection connection, Properties dbProperties, String sql, int id) throws SQLException {
        OrderService ar = new OrderService(connection, dbProperties);
        return ar.queryTableCustomer(sql, id);
    }

    public static void saveAllOrdersToFileTxt(String line, String fileName) throws FileNotFoundException {
        FileService fs = new FileService("data\\"+ fileName +".txt");
        fs.saveToTxt(line);
    }

    public static void saveAllOrdersToFileCsv(String line, String fileName) throws FileNotFoundException {
        FileService fs = new FileService("data\\"+ fileName +".csv");
        fs.saveQuery(line);
    }

    public static double costOfAllTickets(List<Order> orders) {
        double totalCost=0.0;
        for(Order order: orders){
            totalCost+=order.getTotalPrice();
        }
        return totalCost;
    }

    public static List<Customer> getAllCustomers(Connection connection, Properties dbProperties) throws SQLException {
        CustomerService ar = new CustomerService(connection, dbProperties);
        return ar.findAllCustomers();
    }

    public static List<Product> getAllProducts(Connection connection, Properties dbProperties) throws SQLException {
        ProductService ar = new ProductService(connection, dbProperties);
        return ar.findAllProducts();
    }

    public static List<Order> getAllOrders(Connection connection, Properties dbProperties) throws SQLException {
        OrderService ar = new OrderService(connection, dbProperties);
        return ar.findAllOrders();
    }

    public static Order createOrder(Connection connection, Properties dbProperties, int orderId, int customerId, int productId, String paymentMethod) throws SQLException {
        OrderService ar = new OrderService(connection, dbProperties);
        return ar.createOrder(orderId, customerId, productId, paymentMethod);
    }
    public static Product createProduct(Connection connection, Properties dbProperties, int id, String name, double price, String sql) throws SQLException {
        ProductService ar = new ProductService(connection, dbProperties);
        return ar.createProduct(id, name, price, sql);
    }

    public static Customer createCustomer(Connection connection, Properties dbProperties, int id, String name, String category) throws SQLException {
        CustomerService ar = new CustomerService(connection, dbProperties);
        return ar.createCustomer(id, name, category);
    }

    public static void createTables(Connection connection, Properties dbProperties) throws SQLException {
        CreateTablesService ar = new CreateTablesService(connection, dbProperties);
        ar.createTables();
    }

    public static void restoreDbCustomers(Connection connection, Properties dbProperties) throws SQLException {
        CsvToDbService ar = new CsvToDbService(connection, dbProperties);
        ar.restoreDbCustomers(connection, dbProperties);
    }

    public static void restoreDbProducts(Connection connection, Properties dbProperties) throws SQLException {
        CsvToDbService ar = new CsvToDbService(connection, dbProperties);
        ar.restoreDbProducts(connection, dbProperties);
    }

    public static void restoreDbOrders(Connection connection, Properties dbProperties) throws SQLException {
        CsvToDbService ar = new CsvToDbService(connection, dbProperties);
        ar.restoreDbOrders(connection, dbProperties);
    }

    public static void runProgram(Connection connection, Properties dbProperties) throws SQLException, FileNotFoundException {
        RunService ar = new RunService(connection, dbProperties);
        ar.runReporting();
    }



}
