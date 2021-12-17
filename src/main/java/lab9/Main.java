package lab9;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    static final String DB_URL = "jdbc:postgresql://[::1]:5432/java";
    static final String USER = "postgres";
    static final String PASS = "1234";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (!connection.isClosed()){
                System.out.println("Соединение с бд установлено");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
