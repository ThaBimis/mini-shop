package minishop.shop.initdb;

import java.sql.SQLException;
import java.sql.Statement;

public interface CreateTablesIntf {

    void createTables() throws SQLException;
}
