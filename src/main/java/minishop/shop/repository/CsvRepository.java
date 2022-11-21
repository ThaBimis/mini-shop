package minishop.shop.repository;


import lombok.extern.log4j.Log4j2;
import minishop.shop.model.Customer;
import minishop.shop.model.Order;
import minishop.shop.model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
@Log4j2
public class CsvRepository {

    public static void writeToFile(String filename, Customer customer) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        String line = customer.getCustomerId() + "," + customer.getCustomerName() ;
        pw.println(line);
        pw.close();
    }

    public static void writeToFileString(String filename, String line) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(line);
        pw.close();
    }

    public static void writeToFileAllDb(String filename, List<Customer> allCustomers) throws FileNotFoundException {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();
        PrintWriter pw = new PrintWriter(filename);
        pw.print("CustomerId,CustomerName,Category"+"\n");
        for (Customer customer : allCustomers) {
            String line = customer.getCustomerId() + "," + customer.getCustomerName()+"," +customer.getCustomerCategory();
            pw.println(line);
        }
        pw.close();
        log.info("Writing to file: {} was successfull", filename);
    }

    public static void writeToFileAllDbTxt(String filename, String line) throws FileNotFoundException {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();
        PrintWriter pw = new PrintWriter(filename);
        pw.println(line);
        pw.close();
        log.info("Writing to file: {} was successfull", filename);
    }


    public static void writeToFileAllDbProducts(String filename, List<Product> allDepartments) throws FileNotFoundException {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();
        PrintWriter pw = new PrintWriter(filename);
        pw.print("ProductId,ProductName,ProductPrice"+"\n");
        for (Product  product : allDepartments) {
            String line = product.getProductId() + "," + product.getProductName() + "," + product.getPrice();
            pw.println(line);
        }
        pw.close();
        log.info("Writing to file: {} was successfull", filename);
    }

    public static void writeToFileAllDbOrders(String filename, List<Order> allOrders) throws FileNotFoundException {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();
        PrintWriter pw = new PrintWriter(filename);
        pw.print("OrderId,CustomerId,ProductId,LocalDateTime,PaymentMethod,TotalPrice"+"\n");
        for (Order order : allOrders) {
            String line = order.getOrderId() + "," + order.getCustomerId() + ","
                    + order.getProductId() + ","+ order.getDateTime()+ ","+ order.getPaymentMethod()
                    +","+ order.getTotalPrice();
            pw.println(line);
        }
        pw.close();
        log.info("Writing to file: {} was successfull", filename);
    }

}
