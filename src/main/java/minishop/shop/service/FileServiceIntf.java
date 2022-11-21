package minishop.shop.service;

import minishop.shop.model.Customer;
import minishop.shop.model.Order;
import minishop.shop.model.Product;
import minishop.shop.repository.CsvRepository;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileServiceIntf {

    public void saveCustomer(Customer customer) throws FileNotFoundException;

    public void saveQuery(String line) throws FileNotFoundException;

    public void saveAllCustomers(List<Customer> allCustomers) throws FileNotFoundException;

    public void saveToTxt(String line) throws FileNotFoundException;

    public void saveAllOrders(List<Order> allOrders) throws FileNotFoundException;

    public void saveAllProducts(List<Product> allProducts) throws FileNotFoundException;
}
