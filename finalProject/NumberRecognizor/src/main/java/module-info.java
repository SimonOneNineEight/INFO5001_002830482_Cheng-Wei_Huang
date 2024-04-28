module info5100.number_recognition2 {
  requires javafx.controls;
  requires javafx.fxml;
	requires org.tensorflow.core.api;
	requires org.tensorflow;

	opens info5100.numberrecognizor to javafx.fxml;
  exports info5100.numberrecognizor;
  exports info5100.numberrecognizor.model;
  exports info5100.numberrecognizor.view;

}