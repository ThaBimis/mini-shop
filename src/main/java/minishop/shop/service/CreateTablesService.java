package minishop.shop.service;
import minishop.shop.initdb.CreateTables;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CreateTablesService implements CreateTableServiceIntf {

    private final CreateTables createTables;

    public CreateTablesService(Connection connection, Properties dbProperties){
        createTables = new CreateTables(connection, dbProperties);
    };


    public void createTables() throws SQLException {
        createTables.createTables();
    }
}
