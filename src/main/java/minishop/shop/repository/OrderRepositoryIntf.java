package minishop.shop.repository;

import minishop.shop.model.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public interface OrderRepositoryIntf {


    Order getOrder(int orderId) throws SQLException;

    List<Order> getAllOrders() throws SQLException ;


    void updateOrder(int orderId, int customerId, int productId, String sql) throws SQLException;

    void deleteOrder(int orderId) throws SQLException;


    Order createOrder(int orderId, int customerId, int productId, String paymentMethod) throws SQLException;

    double getCustomerDiscount(String categoryType);

    String getCustomerCategory(int customerId) throws SQLException;

    double finalCost(int productId, double priceRate) throws SQLException;

    String queryTable(String sql) throws SQLException;

    String queryTableCustomer(String sql, int customerId) throws SQLException;
}
