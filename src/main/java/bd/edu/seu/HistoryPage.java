package bd.edu.seu;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryPage implements Initializable {

    private ObservableList<HealthService> healthServices;

    @FXML private TableView<HealthService> tableView;
    @FXML private TableColumn<HealthService, String> dateColumn;
    @FXML private TableColumn<HealthService, String> timeColumn;
    @FXML private TableColumn<HealthService, Number> weightColumn;
    @FXML private TableColumn<HealthService, Number> systolicColumn;
    @FXML private TableColumn<HealthService, Number> diastolicColumn;

    public HistoryPage(){

        tableView = new TableView<>();
        dateColumn = new TableColumn<>();
        timeColumn = new TableColumn<>();
        weightColumn = new TableColumn<>();
        systolicColumn = new TableColumn<>();
        diastolicColumn = new TableColumn<>();

        healthServices = FXCollections.observableArrayList();
    }

    public List<HealthService> retrieveData() {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        List<HealthService> HistoryList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM History";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                Double weight = resultSet.getDouble("weight");
                int systolic = resultSet.getInt("systolic");
                int diastolic = resultSet.getInt("diastolic");

                HealthService healthService = new HealthService(LocalDate.parse(date),
                        LocalTime.parse(time),
                        weight,
                        systolic,diastolic);

                HistoryList.add(healthService);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return HistoryList;
    }

    @FXML private void nextPage() throws IOException {
        App.setRoot("lastPage");
    }
    @FXML private void homePage() throws IOException {
        App.setRoot("firstPage");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        weightColumn.setStyle("-fx-alignment: CENTER-RIGHT;");
        systolicColumn.setCellValueFactory(new PropertyValueFactory<>("systolic"));
        systolicColumn.setStyle("-fx-alignment: CENTER-RIGHT;");
        diastolicColumn.setCellValueFactory(new PropertyValueFactory<>("diastolic"));
        diastolicColumn.setStyle("-fx-alignment: CENTER-RIGHT;");

        List<HealthService> healthServiceList = retrieveData();
        healthServices.addAll(healthServiceList);

        tableView.setItems(healthServices);

    }
}
