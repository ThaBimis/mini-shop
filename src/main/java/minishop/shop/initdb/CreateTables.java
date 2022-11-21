package minishop.shop.initdb;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
@Log4j2
public class CreateTables implements CreateTablesIntf{

    private Connection connection;
    private Properties dbProperties;


    public CreateTables(Connection connection, Properties dbProperties){
        this.connection = connection;
        this.dbProperties = dbProperties;

    }

    public void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        String sql =  dbProperties.getProperty("create.table.001");
        statement.executeUpdate(sql);
        sql = dbProperties.getProperty("create.table.002");
        statement.executeUpdate(sql);
        sql =  dbProperties.getProperty("create.table.003");
        statement.executeUpdate(sql);
        log.info("Tables Created");
    }


}
