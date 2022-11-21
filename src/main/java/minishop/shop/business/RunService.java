package minishop.shop.business;

import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static minishop.shop.utils.UtilModule.queryTableCustomer;
import static minishop.shop.utils.UtilModule.saveAllOrdersToFileTxt;

@Log4j2
public class RunService {

    Connection connection;
    Properties dbProperties;

    public RunService(Connection connection, Properties dbProperties){
        this.connection = connection;
        this.dbProperties = dbProperties;

    }



    public void runReporting() throws SQLException, FileNotFoundException {
        while(true){
            String sql = dbProperties.getProperty("select.into.001");
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Welcome Team! -> Press 0 to exit.");
            System.out.println();
            System.out.println("Select the id of the customer you want the number and cost of purchases: ");
            int myint = keyboard.nextInt();
            if(myint==0) break;
            String a = queryTableCustomer(connection, dbProperties, sql, myint);
            log.info("Total no of purchases for particular customer {}", a);
            saveAllOrdersToFileTxt(a, "customer_sums");
            System.out.println("Select the id of the product you want the number and cost of purchases: ");
            myint = keyboard.nextInt();
            if(myint==0) break;
            sql = dbProperties.getProperty("select.into.012");
            a = queryTableCustomer(connection, dbProperties, sql, myint);
            log.info("Total no of purchases for particular product {}", a);
            saveAllOrdersToFileTxt(a, "product_sums");
        }
    }
}
