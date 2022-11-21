package minishop.shop.service;


import minishop.shop.initdb.CsvToDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CsvToDbService implements CsvToDServiceIntf{

    private final CsvToDb csvToDb;


    public CsvToDbService(Connection connection, Properties dbProperties){
        csvToDb = new CsvToDb(connection, dbProperties);
    }

    public void restoreDbCustomers(Connection connection, Properties dbProperties){
        csvToDb.restoreDbCustomers(connection, dbProperties);
    }

    public void restoreDbProducts(Connection connection, Properties dbProperties) {
        csvToDb.restoreDbProducts(connection, dbProperties);
    }

    public void restoreDbOrders(Connection connection, Properties dbProperties){
        csvToDb.restoreDbOrders(connection, dbProperties);
    }

}
