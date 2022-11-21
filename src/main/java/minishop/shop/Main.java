package minishop.shop;

import lombok.extern.log4j.Log4j2;
import minishop.shop.dbconnection.DBConnector;
import minishop.shop.enums.CustomerCategory;
import minishop.shop.enums.PaymentMethod;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static minishop.shop.utils.UtilModule.*;

@Log4j2
public class Main {

    private static Connection connection = null;

    private static Properties dbProperties = null;


    public static void main(String[] args) throws SQLException, FileNotFoundException {

        initialize();
        createTables(connection, dbProperties);
        log.info("Tables Created");
        restoreDbCustomers(connection, dbProperties);
        restoreDbProducts(connection,dbProperties);
        restoreDbOrders(connection, dbProperties);
        runBusiness();
    }


    private static void runBusiness() throws SQLException, FileNotFoundException {
        createCustomer(connection, dbProperties, 5,"Thanasis Bimis", CustomerCategory.Individual.name()); //create a new customer

        createOrder(connection, dbProperties, 4, 1, 2, PaymentMethod.CASH.name());

        String sql = dbProperties.getProperty("select.into.001");
        String a = queryTableCustomer(connection, dbProperties, sql, 1);
        log.info("Total no of purchases for particular customer {}", a);
        saveAllOrdersToFileTxt(a, "customer_sums");

        sql = dbProperties.getProperty("select.into.012");
        a = queryTableCustomer(connection, dbProperties, sql, 3);
        log.info("Total no of purchases for particular product {}", a);
        saveAllOrdersToFileTxt(a, "product_sums");
    }

    private static  void initialize(){
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        dbProperties = connector.getDbProperties();
    }

}
