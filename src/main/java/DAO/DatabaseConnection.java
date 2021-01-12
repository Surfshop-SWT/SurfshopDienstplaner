package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Tim Lueneburg
 * Date: 24.12.2020
 */
public class DatabaseConnection {

    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/dienstplaner";
        String user = "root";
        String pass = "h@QKz&&A^K!8mAc5&LYJHvN4iRv!AF";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
