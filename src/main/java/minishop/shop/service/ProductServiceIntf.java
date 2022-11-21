package minishop.shop.service;

import minishop.shop.model.Product;
import minishop.shop.repository.ProductRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface ProductServiceIntf {

    Product findProductWithId(int ProductId) throws SQLException;

    List<Product> findAllProducts() throws SQLException;

    Product createProduct(int ProductId, String name, double price, String sql) throws SQLException;

    void updateProduct(int ProductId, String ProductName, double price, String sql) throws SQLException;

    void deleteProduct(int ProductId) throws SQLException;
}
