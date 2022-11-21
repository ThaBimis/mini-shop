package minishop.shop.service;

import minishop.shop.model.Order;
import minishop.shop.repository.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface OrderServiceIntf {


    Order findOrderWithId(int OrderId) throws SQLException;

    List<Order> findAllOrders() throws SQLException;

    Order createOrder(int OrderId, int customerId, int productId, String paymentMethod) throws SQLException;

    void updateOrder(int OrderId, int customerId, int productId, String sql) throws SQLException;

    void deleteOrder(int OrderId) throws SQLException;

    String queryTable(String sql) throws SQLException;

    String queryTableCustomer(String sql, int id) throws SQLException;
}
