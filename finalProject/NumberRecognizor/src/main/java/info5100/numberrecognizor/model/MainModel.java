package info5100.numberrecognizor.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.shape.Shape;

public class MainModel {

  private final ObservableList<Shape> shapes;

  public MainModel() {
    shapes = FXCollections.observableArrayList();
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  public ObservableList<Shape> getShapes() {
    return shapes;
  }

  public void clearShapes() {
    shapes.clear();
  }
}