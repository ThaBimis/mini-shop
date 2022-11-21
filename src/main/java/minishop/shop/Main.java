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
import java.util.Scanner;

import static minishop.shop.utils.UtilModule.*;

@Log4j2
public class Main {

    private static Connection connection = null;

    private static Properties dbProperties = null;


    public static void main(String[] args) throws SQLException, FileNotFoundException {

        initialize();
        createTables(connection, dbProperties);
        restoreDb();
        runBusiness();
//        runProgram(connection, dbProperties);
    }


    private static void runBusiness() throws SQLException, FileNotFoundException {
        //Create customer
        createCustomer(connection, dbProperties, 5,"Thanasis Bimis", CustomerCategory.Individual.name());

        //Create order
        createOrder(connection, dbProperties, 3, 1, 2, PaymentMethod.CASH.name());

        //report1
        String sql = dbProperties.getProperty("select.into.001");
        String a = queryTableCustomer(connection, dbProperties, sql, 1);

        //showing to logs
        log.info("Total no of purchases for particular customer {}", a);

        //saving to txt
        saveAllOrdersToFileTxt(a, "customer_sums");

        //report2
        sql = dbProperties.getProperty("select.into.012");
        a = queryTableCustomer(connection, dbProperties, sql, 3);

        //showing to logs
        log.info("Total no of purchases for particular product {}", a);

        //saving to txt
        saveAllOrdersToFileTxt(a, "product_sums");


    }

    private static  void initialize(){
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        dbProperties = connector.getDbProperties();
    }

    private static void restoreDb() throws SQLException {
        restoreDbCustomers(connection, dbProperties);
        restoreDbProducts(connection,dbProperties);
        restoreDbOrders(connection, dbProperties);
    }



}
