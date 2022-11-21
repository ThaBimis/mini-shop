package minishop.shop.service;


import minishop.shop.model.Order;
import minishop.shop.repository.OrderRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class OrderService implements OrderServiceIntf{

    private final OrderRepository repository;

    public OrderService(Connection connection, Properties dbProperties) throws SQLException {
        repository = new OrderRepository(connection, dbProperties);
    }

    public Order findOrderWithId(int OrderId) throws SQLException {
        return repository.getOrder(OrderId);
    }

    public List<Order> findAllOrders() throws SQLException {
        return repository.getAllOrders();
    }

    public Order createOrder(int OrderId, int customerId, int productId, String paymentMethod) throws SQLException {
        return repository.createOrder(OrderId, customerId, productId, paymentMethod);
    }

    public void updateOrder(int OrderId, int customerId, int productId, String sql) throws SQLException {
        repository.updateOrder(OrderId, customerId, productId, sql);
    }

    public void deleteOrder(int OrderId) throws SQLException {
        repository.deleteOrder(OrderId);
    }

    public String queryTable(String sql) throws SQLException {
        return repository.queryTable(sql);
    }

    public String queryTableCustomer(String sql, int id) throws SQLException {
        return repository.queryTableCustomer(sql, id);
    }




}
