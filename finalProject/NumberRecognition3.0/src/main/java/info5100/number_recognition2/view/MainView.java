package info5100.number_recognition2.view;

import info5100.number_recognition2.model.MainModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;


public class MainView extends BorderPane {

  private HBox buttonsPanel;
  private Button lineButton, rectangleButton, squareButton, circleButton, triangleButton, ellipseButton, freehandButton, clearButton, recognizeButton;
  private DrawArea drawArea;

  public MainView(MainModel model) {
    lineButton = new Button("Line");
    rectangleButton = new Button("Rectangle");
    squareButton = new Button("Square");
    circleButton = new Button("Circle");
    triangleButton = new Button("Triangle");
    ellipseButton = new Button("Ellipse");
    freehandButton = new Button("Freehand");
    clearButton = new Button("Clear");
    recognizeButton = new Button("Recognize Number");


    buttonsPanel = new HBox();
    buttonsPanel.setAlignment(Pos.CENTER);
    buttonsPanel.setSpacing(10);
    buttonsPanel.setPadding(new Insets(10, 10, 10, 10));
    buttonsPanel.getChildren().addAll(lineButton, rectangleButton, squareButton, circleButton, triangleButton, ellipseButton, freehandButton, clearButton, recognizeButton);

    drawArea = new DrawArea(model);
    drawArea.setWidth(800);
    drawArea.setHeight(600);

    setTop(buttonsPanel);
    setCenter(drawArea);
  }

  public HBox getButtonsPanel() {
    return buttonsPanel;
  }

  public Button getLineButton() {
    return lineButton;
  }

  public Button getRectangleButton() {
    return rectangleButton;
  }

  public Button getSquareButton() {
    return squareButton;
  }

  public Button getCircleButton() {
    return circleButton;
  }

  public Button getTriangleButton() {
    return triangleButton;
  }

  public Button getEllipseButton() {
    return ellipseButton;
  }

  public Button getFreehandButton() {
    return freehandButton;
  }

  public Button getClearButton() {
    return clearButton;
  }

  public DrawArea getDrawArea() {
    return drawArea;
  }

  public Button getRecognizeButton() {
    return recognizeButton;
  }
}