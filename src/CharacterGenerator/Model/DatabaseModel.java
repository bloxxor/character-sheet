package CharacterGenerator.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseModel {

    private static String url = "jdbc:mysql://localhost:3306/characterGenerator";
    private static String user = "root";
    private static String password = "";

    public static Connection connection;

    public static void connect() {

        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
