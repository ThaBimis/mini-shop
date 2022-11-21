package minishop.shop.service;



import minishop.shop.model.Customer;
import minishop.shop.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CustomerService implements CustomerServiceIntf{

    private final CustomerRepository repository;

    public CustomerService(Connection connection, Properties dbProperties){
        repository = new CustomerRepository(connection, dbProperties);
    }

    public Customer findCustomerWithId(int customerId) throws SQLException {
        return repository.getCustomer(customerId);
    }

    public List<Customer> findAllCustomers() throws SQLException {
        return repository.getAllCustomers();
    }

    public Customer createCustomer(int customerId, String name, String category) throws SQLException {
        return repository.createCustomer(customerId, name, category);
    }

    public void updateCustomer(int customerId, String customerName, String sql) throws SQLException {
        repository.updateCustomer(customerId, customerName, sql);
    }

    public void deleteCustomer(int customerId) throws SQLException {
        repository.deleteCustomer(customerId);
    }

}
