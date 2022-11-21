package minishop.shop.repository;

import minishop.shop.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface ProductRepositoryIntf {

    Product getProduct(int ProductId) throws SQLException;

    List<Product> getAllProducts() throws SQLException;


    void updateProduct(int ProductId, String ProductName, double price, String sql) throws SQLException;

    void deleteProduct(int ProductId) throws SQLException;


    Product createProduct(int ProductId, String name, double price, String sql) throws SQLException;
}
