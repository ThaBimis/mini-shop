package minishop.shop.initdb;

import java.sql.Connection;
import java.util.Properties;

public interface CsvToDbIntf {

    void restoreDbCustomers(Connection connection, Properties dbProperties);
    void restoreDbProducts(Connection connection, Properties dbProperties);
    public void restoreDbOrders(Connection connection, Properties dbProperties);

}
