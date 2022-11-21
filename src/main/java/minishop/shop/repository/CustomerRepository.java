package minishop.shop.repository;


import lombok.extern.log4j.Log4j2;
import minishop.shop.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Log4j2
public class CustomerRepository implements CustomerRepositoryIntf{
    private final Connection connection; //prosthesa final


    private final Properties dbProperties;

    public CustomerRepository(Connection connection, Properties dbProperties) {
        this.connection = connection;
        this.dbProperties = dbProperties;

    }

    public Customer getCustomer(int customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.005") + customerId;
        ResultSet rs = statement.executeQuery(sql);
        Customer customer = null;
        while(rs.next()){

            String customerName = rs.getString("name");
            String customerCategory = rs.getString("category");
            customer = new Customer(customerId, customerName, customerCategory);
            customer.setCustomerName(customerName);
        }
        rs.close();
        return customer;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> allCustomers = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.003");
        ResultSet rs = statement.executeQuery(sql);
        Customer customer;
        while(rs.next()){
            String customerId = rs.getString("id");
            String customerName = rs.getString("name");
            String customerCategory = rs.getString("category");

            customer = new Customer(Integer.parseInt(customerId), customerName, customerCategory);
            customer.setCustomerName(customerName);
            log.debug(customer);
            allCustomers.add(customer);
        }
        rs.close();
        return allCustomers;
    }


    public void updateCustomer(int customerId, String customerName, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,customerId);
        statement.setString(2, customerName);
        statement.executeUpdate();

    }

    public void deleteCustomer(int customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.004") +customerId;
        statement.executeUpdate(sql);

    }


    public Customer createCustomer(int customerId, String name, String category) throws SQLException {
        String sql = dbProperties.getProperty("insert.into.001");
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, customerId);
        statement.setString(2,name);
        statement.setString(3, category);
        statement.executeUpdate();

        Customer customer =  new Customer(customerId, name, category);
        return customer;
    }


}
