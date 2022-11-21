package minishop.shop.service;

import minishop.shop.model.Customer;
import minishop.shop.model.Order;
import minishop.shop.model.Product;
import minishop.shop.repository.CsvRepository;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileServiceIntf {

    void saveCustomer(Customer customer) throws FileNotFoundException;

    void saveQuery(String line) throws FileNotFoundException;

    void saveAllCustomers(List<Customer> allCustomers) throws FileNotFoundException;

    void saveToTxt(String line) throws FileNotFoundException;

    void saveAllOrders(List<Order> allOrders) throws FileNotFoundException;

    void saveAllProducts(List<Product> allProducts) throws FileNotFoundException;
}
