package minishop.shop.service;



import minishop.shop.model.Customer;
import minishop.shop.model.Order;
import minishop.shop.model.Product;
import minishop.shop.repository.CsvRepository;

import java.io.FileNotFoundException;
import java.util.List;

public class FileService implements FileServiceIntf{
    private final String filename;

    public FileService(String filename){
        this.filename = filename;
    }

    public void saveCustomer(Customer customer) throws FileNotFoundException {
        CsvRepository.writeToFile(filename, customer);
    }

    public void saveQuery(String line) throws FileNotFoundException {
        CsvRepository.writeToFileString(filename, line);
    }

    public void saveAllCustomers(List<Customer> allCustomers) throws FileNotFoundException {
        CsvRepository.writeToFileAllDb(filename, allCustomers);
    }

    public void saveToTxt(String line) throws FileNotFoundException {
        CsvRepository.writeToFileAllDbTxt(filename, line);
    }

    public void saveAllOrders(List<Order> allOrders) throws FileNotFoundException {
        CsvRepository.writeToFileAllDbOrders(filename, allOrders);
    }

    public void saveAllProducts(List<Product> allProducts) throws FileNotFoundException {
        CsvRepository.writeToFileAllDbProducts(filename, allProducts);
    }

}
