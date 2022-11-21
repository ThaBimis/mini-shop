package minishop.shop.initdb;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


@Log4j2
public class CsvToDb implements CsvToDbIntf{

    private Connection connection;
    private Properties dbProperties;

    public CsvToDb(Connection connection, Properties dbProperties) {
        this.connection = connection;
        this.dbProperties = dbProperties;
    }

    public void restoreDbCustomers(Connection connection, Properties dbProperties) {


        String csvFilePath = "initdb\\initDbCustomers.csv";

        int batchSize = 20;


        try {
            String sql =dbProperties.getProperty("insert.into.001");
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String name = data[1];
                String category = data[2];


                statement.setInt(1, Integer.parseInt(id));
                statement.setString(2, name);
                statement.setString(3, category);
                statement.addBatch();
                statement.executeBatch();
            }

            lineReader.close();
            // execute the remaining queries
            statement.executeBatch();



        } catch (IOException ex) {
            log.error(ex);
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        }

    }

    public void restoreDbProducts(Connection connection, Properties dbProperties) {


        String csvFilePath = "initdb\\initDbProducts.csv";

//        int batchSize = 20;


        try {
            String sql =dbProperties.getProperty("insert.into.002");
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

//            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String id = data[0];
                String name = data[1];
                String price = data[2];


                statement.setInt(1, Integer.parseInt(id));
                statement.setString(2, name);
                statement.setDouble(3, Double.parseDouble(price));
                statement.addBatch();
                statement.executeBatch();
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();



        } catch (IOException ex) {
            log.error(ex);
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        }

    }

    public void restoreDbOrders(Connection connection, Properties dbProperties) {


        String csvFilePath = "initdb\\initDbOrders.csv";

        int batchSize = 20;


        try {
            String sql =dbProperties.getProperty("insert.into.003");
            PreparedStatement statement = connection.prepareStatement(sql);
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String orderId = data[0];
                String customerId = data[1];
                String productId = data[2];
                String total = data[3];
                String dateTime = data[4];
                String paymentMethod = data[5];


                statement.setInt(1, Integer.parseInt(orderId));
                statement.setInt(2, Integer.parseInt(customerId));
                statement.setInt(3, Integer.parseInt(productId));
                statement.setDouble(4, Double.parseDouble(total));
                statement.setString(5, dateTime);
                statement.setString(6, paymentMethod);
                statement.addBatch();
                statement.executeBatch();
            }

            lineReader.close();

            // execute the remaining queries
            statement.executeBatch();



        } catch (IOException ex) {
            log.error(ex);
        } catch (SQLException ex) {
            log.error(ex);
            ex.printStackTrace();
        }

    }
}
