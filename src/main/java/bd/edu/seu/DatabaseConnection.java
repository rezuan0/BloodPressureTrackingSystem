package bd.edu.seu;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class DatabaseConnection {

    private final String DB_URL = "jdbc:mysql://localhost/happyFamily";
    private final String DB_USER = "rezu";
    private final String DB_PASS = "java";

    public Connection getConnection() {
        try {

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.printf("Connection Okay !!!\n");
            return connection;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void saveToDatabase(HealthService service) {
        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();

            String query = String.format("insert into History values('%s', '%s', %f, %d, %d)",
                    service.getDate(),
                    service.getTime(),
                    service.getWeight(),
                    service.getSystolic(),
                    service.getDiastolic());

            statement.executeUpdate(query);
            System.out.printf("Inserted into databases \n");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
