package minishop.shop.dbconnection;

import lombok.extern.log4j.Log4j2;
import minishop.shop.Main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Log4j2
public class DBConnector {

    private Connection connection;

    private Properties dbProperties = null;

    public DBConnector(){
        log.info("Started Program");
        this.connection = initiateDatabase();
        log.info("Database Created");
    }

    public Connection getConnection() {
        return connection;
    }

    public Properties getDbProperties() {
        return dbProperties;
    }

    private Connection initiateDatabase() {
        try{
            String schemaName;
            log.info("Started InitiateDatabase()");
            readProperties();
            useMySqlDriver();
            connection = connectToMySql();
            schemaName = dbProperties.getProperty("schema.name");
            createDb(connection, schemaName);
            connection = connectToMySql(schemaName);
            log.debug("Used createDb()");



        }catch(SQLException e){
            log.error("Problem with SQL" + e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            log.error("System exception" + e.getMessage());
        }
        return connection;
    }

    private  void readProperties() throws IOException {
        InputStream inStream = Main.class.getClassLoader().getResourceAsStream("mysql.properties");
        dbProperties = new Properties();
        dbProperties.load(inStream);

    }

    private static void useMySqlDriver() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
    }


    private  Connection connectToMySql() throws SQLException {

        String dbUrl = dbProperties.getProperty("connection.dbUrl");
        String userName = dbProperties.getProperty("connection.userName");
        String password = dbProperties.getProperty("connection.password");
        connection = DriverManager.getConnection(dbUrl, userName, password);
        return connection;

    }

    private Connection connectToMySql(String schema) throws SQLException {

        String dbUrl = dbProperties.getProperty("connection.dbUrl");
        String userName = dbProperties.getProperty("connection.userName");
        String password = dbProperties.getProperty("connection.password");
        connection = DriverManager.getConnection(dbUrl+"/"+schema, userName, password);
        return connection;

    }

    public void createDb(Connection connection, String databaseName) throws SQLException {
        Statement s = connection.createStatement();
        String sql = dbProperties.getProperty("create.database.001");
        s.executeUpdate(sql+" "+databaseName);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void alterTable(Connection connection, String databaseName) throws SQLException{
        Statement s = connection.createStatement();
        String sql = dbProperties.getProperty("alter.table.001");
        s.executeUpdate(sql+" "+databaseName);
        sql = dbProperties.getProperty("alter.table.002");
        s.executeUpdate(sql+" "+databaseName);
    }
}
