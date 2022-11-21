package minishop.shop.service;

import minishop.shop.model.Product;
import minishop.shop.repository.ProductRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public interface ProductServiceIntf {

    public Product findProductWithId(int ProductId) throws SQLException;

    public List<Product> findAllProducts() throws SQLException;

    public Product createProduct(int ProductId, String name, double price, String sql) throws SQLException;

    public void updateProduct(int ProductId, String ProductName, double price, String sql) throws SQLException;

    public void deleteProduct(int ProductId) throws SQLException;
}
