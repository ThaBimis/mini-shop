package minishop.shop.service;

import java.sql.Connection;
import java.util.Properties;

public interface CsvToDServiceIntf {

   void restoreDbCustomers(Connection connection, Properties properties);

   void restoreDbProducts(Connection connection, Properties properties);

   void restoreDbOrders(Connection connection, Properties properties);
}
