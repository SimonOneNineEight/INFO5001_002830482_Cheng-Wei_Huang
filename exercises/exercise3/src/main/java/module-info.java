module calculator.exercise3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens calculator.exercise3 to javafx.fxml;
    exports calculator.exercise3;
}