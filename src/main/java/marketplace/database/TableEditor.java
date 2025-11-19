package marketplace.database;

import java.sql.*;

public class TableEditor {
    public static void editTable(String str) {
        Connection.createConnection();
        try {
            Connection.getStatement().executeUpdate(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Table changed successfully");
        Connection.closeConnection();
    }
}
