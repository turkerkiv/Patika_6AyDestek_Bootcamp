package Week6.PatikaClone.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection conn = null;

    private static void connectToDB()
    {
        try{
            conn = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConn()
    {
        if(conn == null)
        {
            connectToDB();
        }
        return conn;
    }
}
