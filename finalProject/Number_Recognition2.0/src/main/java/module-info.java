module info5100.number_recognition2 {
  requires javafx.controls;
  requires javafx.fxml;
    requires org.tensorflow.ndarray;
	requires org.tensorflow.core.api;

	opens info5100.number_recognition2 to javafx.fxml;
  exports info5100.number_recognition2;
  exports info5100.number_recognition2.model;
  exports info5100.number_recognition2.view;

}