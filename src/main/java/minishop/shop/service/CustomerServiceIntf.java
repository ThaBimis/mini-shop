package minishop.shop.service;

import minishop.shop.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface CustomerServiceIntf {

    public Customer findCustomerWithId(int customerId) throws SQLException;

    public List<Customer> findAllCustomers() throws SQLException;

    public Customer createCustomer(int customerId, String name, String category) throws SQLException;

    public void updateCustomer(int customerId, String customerName, String sql) throws SQLException;

    public void deleteCustomer(int customerId) throws SQLException;
}
