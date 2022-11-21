package minishop.shop.repository;

import minishop.shop.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface CustomerRepositoryIntf {

    Customer getCustomer(int customerId) throws SQLException ;

    List<Customer> getAllCustomers() throws SQLException;


    void updateCustomer(int customerId, String customerName, String sql) throws SQLException;

    void deleteCustomer(int customerId) throws SQLException;


    Customer createCustomer(int customerId, String name, String category) throws SQLException;
}
