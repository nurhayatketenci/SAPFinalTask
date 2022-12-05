package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private static final String url = "jdbc:mysql://localhost:3306/hybris";
    private static final String name = "root";
    private static final String password = "";

    private static Connection instance = null;

    private MySqlConnector(){

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (instance == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            instance = DriverManager.getConnection(url, name, password);
        }
        return instance;
    }
}
