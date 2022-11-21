package minishop.shop.repository;


import lombok.extern.log4j.Log4j2;
import minishop.shop.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Log4j2
public class ProductRepository implements ProductRepositoryIntf{

    private final Connection connection; //prosthesa final
    private final Properties dbProperties;



    public ProductRepository(Connection connection, Properties dbProperties) {
        this.connection = connection;
        this.dbProperties = dbProperties;

    }

    public Product getProduct(int ProductId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.006")+ ProductId;
        ResultSet rs = statement.executeQuery(sql);
        Product Product = null;
        while(rs.next()){

            String ProductName = rs.getString("name");
            String productPrice = rs.getString("price");
            Product = new Product(ProductId, ProductName, Integer.parseInt(productPrice));
            Product.setProductName(ProductName);
        }
        rs.close();
        return Product;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> allProducts = new ArrayList<>();
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("select.into.007");
        ResultSet rs = statement.executeQuery(sql);
        Product Product;
        while(rs.next()){
            int ProductId = rs.getInt("id");
            String ProductName = rs.getString("name");
            double ProductPrice = rs.getDouble("price");

            Product = new Product(ProductId, ProductName, ProductPrice);
            Product.setProductName(ProductName);
            log.debug(Product);
            allProducts.add(Product);
        }
        rs.close();
        return allProducts;
    }


    public void updateProduct(int ProductId, String ProductName, double price, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,ProductId);
        statement.setString(2, ProductName);
        statement.setDouble(2, price);
        statement.executeUpdate();

    }

    public void deleteProduct(int ProductId) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = dbProperties.getProperty("delete.into.001")+ ProductId;
        statement.executeUpdate(sql);

    }


    public Product createProduct(int ProductId, String name, double price, String sql) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ProductId);
        statement.setString(2,name);
        statement.setDouble(3, price);
        statement.executeUpdate();

        Product Product =  new Product(ProductId, name, price);
        return Product;
    }
}
