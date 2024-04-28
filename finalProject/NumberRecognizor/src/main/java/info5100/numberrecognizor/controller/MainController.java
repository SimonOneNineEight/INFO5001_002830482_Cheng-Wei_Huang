package info5100.numberrecognizor.controller;

import info5100.numberrecognizor.model.NumberRecognizer;
import info5100.numberrecognizor.model.Point;
import info5100.numberrecognizor.model.ImageProcessor;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.shape.*;

import info5100.numberrecognizor.view.*;
import info5100.numberrecognizor.model.MainModel;


public class MainController {

  private final MainModel model;
  private final MainView view;

  public MainController(MainModel model, MainView view) {
    this.model = model;
    this.view = view;

    initializeButtonListeners();
    initializeCanvasListeners();
  }

  private void initializeButtonListeners() {
    DrawArea drawArea = view.getDrawArea();
    view.getLineButton().setOnAction(e -> drawArea.setCurrentShapeType("Line"));
    view.getRectangleButton().setOnAction(e -> drawArea.setCurrentShapeType("Rectangle"));
    view.getSquareButton().setOnAction(e -> drawArea.setCurrentShapeType("Square"));
    view.getCircleButton().setOnAction(e -> drawArea.setCurrentShapeType("Circle"));
    view.getTriangleButton().setOnAction(e -> drawArea.setCurrentShapeType("Triangle"));
    view.getEllipseButton().setOnAction(e -> drawArea.setCurrentShapeType("Ellipse"));
    view.getFreehandButton().setOnAction(e -> drawArea.setCurrentShapeType("Freehand"));
    view.getClearButton().setOnAction(e -> {
      model.clearShapes();
      drawArea.clearLines();
      drawArea.draw();
    });
    view.getRecognizeButton().setOnAction(e -> this.recognizeNumber());

  }

  private void initializeCanvasListeners() {
    view.getDrawArea().setOnMousePressed(event -> {
      if (view.getDrawArea().getCurrentShapeType().equals("Freehand")) {
        view.getDrawArea().startNewLine(event.getX(), event.getY());
      } else {
        view.getDrawArea().setStartDrag(new Point(event.getX(), event.getY()));
        view.getDrawArea().setEndDrag(new Point(event.getX(), event.getY()));
      }
    });

    view.getDrawArea().setOnMouseReleased(event -> {
      if (!view.getDrawArea().getCurrentShapeType().equals("Freehand")) {
        Point startDrag = view.getDrawArea().getStartDrag();
        Point endDrag = view.getDrawArea().getEndDrag();
        if (startDrag != null && endDrag != null) {
          Shape shape = createShape(startDrag.getX(), startDrag.getY(), endDrag.getX(), endDrag.getY());
          model.addShape(shape);
          view.getDrawArea().draw();
        }
        view.getDrawArea().setStartDrag(null);
        view.getDrawArea().setEndDrag(null);
      }
    });

    view.getDrawArea().setOnMouseDragged(event -> {
      if (view.getDrawArea().getCurrentShapeType().equals("Freehand")) {
        view.getDrawArea().addPointToCurrentLine(event.getX(), event.getY());
      } else {
        view.getDrawArea().setEndDrag(new Point(event.getX(), event.getY()));
      }
      view.getDrawArea().draw();
    });
  }

  public Shape createShape(double x1, double y1, double x2, double y2) {
    String currentShapeType = view.getDrawArea().getCurrentShapeType();
    switch (currentShapeType) {
      case "Rectangle":
        return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
      case "Square":
        double size = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        return new Rectangle(Math.min(x1, x2), Math.min(y1, y2), size, size);
      case "Circle":
        double radius = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)) / 2;
        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        return new Ellipse(centerX, centerY, radius, radius);
      case "Ellipse":
        double radiusX = Math.abs(x1 - x2) / 2;
        double radiusY = Math.abs(y1 - y2) / 2;
        double ellipseCenterX = (x1 + x2) / 2;
        double ellipseCenterY = (y1 + y2) / 2;
        return new Ellipse(ellipseCenterX, ellipseCenterY, radiusX, radiusY);
      case "Line":
        return new Line(x1, y1, x2, y2);
      case "Triangle":
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(x1, y2, (x1 + x2) / 2, y1, x2, y2);
        return triangle;
      default:
        return null;
    }
  }

  private void recognizeNumber() {
    NumberRecognizer recognizer = new NumberRecognizer();
    // Get the image data from the canvas
    Image image = view.getDrawArea().snapshot(null, null);

    // Convert the image to a format suitable for your number recognition model or API
    // For example, you can save the image to a file and then load it
    // or convert it to a byte array
    // Here, we assume you have a method called `recognizeNumber` in the `NumberRecognizer` class
    float[][] imageData = ImageProcessor.convertImageToFloatArray(image);
    int recognizedNumber = recognizer.recognizeNumber(imageData);

    System.out.println(recognizedNumber);

    // Display the recognized number in an alert
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Number Recognition");
    alert.setHeaderText(null);
    alert.setContentText("Recognized Number: " + recognizedNumber);
    alert.showAndWait();
  }

}

