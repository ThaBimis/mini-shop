package minishop.shop.service;


import minishop.shop.model.Product;
import minishop.shop.repository.ProductRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ProductService implements ProductServiceIntf{

    private final ProductRepository repository;

    public ProductService(Connection connection, Properties dbProperties) throws SQLException {
        repository = new ProductRepository(connection, dbProperties);
    }

    public Product findProductWithId(int ProductId) throws SQLException {
        return repository.getProduct(ProductId);
    }

    public List<Product> findAllProducts() throws SQLException {
        return repository.getAllProducts();
    }

    public Product createProduct(int ProductId, String name, double price, String sql) throws SQLException {
        return repository.createProduct(ProductId, name, price, sql);
    }

    public void updateProduct(int ProductId, String ProductName, double price, String sql) throws SQLException {
        repository.updateProduct(ProductId, ProductName, price, sql);
    }

    public void deleteProduct(int ProductId) throws SQLException {
        repository.deleteProduct(ProductId);
    }
}
