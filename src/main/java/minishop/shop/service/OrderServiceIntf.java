package minishop.shop.service;

import minishop.shop.model.Order;
import minishop.shop.repository.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface OrderServiceIntf {


    public Order findOrderWithId(int OrderId) throws SQLException;

    public List<Order> findAllOrders() throws SQLException;

    public Order createOrder(int OrderId, int customerId, int productId, String paymentMethod) throws SQLException;

    public void updateOrder(int OrderId, int customerId, int productId, String sql) throws SQLException;

    public void deleteOrder(int OrderId) throws SQLException;

    public String queryTable(String sql) throws SQLException;

    public String queryTableCustomer(String sql, int id) throws SQLException;
}
