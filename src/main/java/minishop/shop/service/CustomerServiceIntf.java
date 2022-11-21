package minishop.shop.service;

import minishop.shop.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface CustomerServiceIntf {

    Customer findCustomerWithId(int customerId) throws SQLException;

    List<Customer> findAllCustomers() throws SQLException;

    Customer createCustomer(int customerId, String name, String category) throws SQLException;

    void updateCustomer(int customerId, String customerName, String sql) throws SQLException;

    void deleteCustomer(int customerId) throws SQLException;
}
