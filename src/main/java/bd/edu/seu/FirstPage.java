package bd.edu.seu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class FirstPage {
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField systolicField;
    @FXML
    private TextField diastolicField;

    public FirstPage() {
        dateField = new DatePicker();
        weightField = new TextField();
        systolicField = new TextField();
        diastolicField = new TextField();
    }

    private void clearField() {

        Alert alerts = new Alert(Alert.AlertType.INFORMATION);
        alerts.setTitle("Confirmations...");
        alerts.setHeaderText(null);
        alerts.setContentText("Saved into Database... ");
        alerts.showAndWait();

        dateField.setValue(null);
        weightField.clear();
        systolicField.clear();
        diastolicField.clear();


    }

    @FXML
    private void handleSave() {
        LocalDate date = dateField.getValue();
        LocalTime time = LocalTime.now();
        double weight = Double.parseDouble(weightField.getText());
        int systolic = Integer.parseInt(systolicField.getText());
        int diastolic = Integer.parseInt(diastolicField.getText());


        HealthService service = new HealthService(date, time, weight, systolic, diastolic);
        System.out.println(service);

        DatabaseConnection connection = new DatabaseConnection();
        connection.saveToDatabase(service);

        clearField();


    }

    @FXML
    private void historyTable() throws IOException {
        App.setRoot("historyPage");
    }
}
