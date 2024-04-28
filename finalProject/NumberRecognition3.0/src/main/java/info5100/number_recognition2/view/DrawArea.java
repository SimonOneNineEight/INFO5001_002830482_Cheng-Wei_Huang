package info5100.number_recognition2.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

import info5100.number_recognition2.model.MainModel;
import info5100.number_recognition2.model.Point;

public class DrawArea extends Canvas {

  private List<List<Point>> lines;
  private List<Point> currentLine;
  private Point startDrag;
  private Point endDrag;
  private Color color;
  private String currentShapeType;

  private MainModel model;

  public DrawArea(MainModel model) {
    lines = new ArrayList<>();
    currentLine = new ArrayList<>();
    color = Color.BLACK;
    currentShapeType = "Freehand";
    this.model = model;

    setOnMousePressed(this::handleMousePressed);
    setOnMouseReleased(this::handleMouseReleased);
    setOnMouseDragged(this::handleMouseDragged);
  }

  public void clearLines() {
    lines.clear();
    currentLine.clear();
    GraphicsContext gc = getGraphicsContext2D();
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, getWidth(), getHeight());
  }

  public Shape makeShape(double x1, double y1, double x2, double y2) {
    switch (currentShapeType) {
      case "Line":
        return new Line(x1, y1, x2, y2);
      case "Rectangle":
        double width = Math.abs(x2 - x1);
        double height = Math.abs(y2 - y1);
        double x = Math.min(x1, x2);
        double y = Math.min(y1, y2);
        return new Rectangle(x, y, width, height);
      case "Square":
        double size = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        x = Math.min(x1, x2);
        y = Math.min(y1, y2);
        return new Rectangle(x, y, size, size);
      case "Circle":
        double circleCenterX = (x1 + x2) / 2;
        double circleCenterY = (y1 + y2) / 2;
        double radius = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) / 2;
        return new Ellipse(circleCenterX, circleCenterY, radius, radius);
      case "Ellipse":
        double ellipseCenterX = (x1 + x2) / 2;
        double ellipseCenterY = (y1 + y2) / 2;
        double radiusX = Math.abs(x2 - x1) / 2;
        double radiusY = Math.abs(y2 - y1) / 2;
        return new Ellipse(ellipseCenterX, ellipseCenterY, radiusX, radiusY);
      case "Triangle":
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(x1, y2, (x1 + x2) / 2, y1, x2, y2);
        return triangle;
      default:
        return null;
    }
  }

  public void handleMousePressed(MouseEvent event) {
    if (currentShapeType.equals("Freehand")) {
      currentLine = new ArrayList<>();
      currentLine.add(new Point(event.getX(), event.getY()));
      lines.add(currentLine);
    } else {
      startDrag = new Point(event.getX(), event.getY());
      endDrag = startDrag;
    }
  }

  public void handleMouseReleased(MouseEvent event) {
    if (!currentShapeType.equals("Freehand")) {
      Shape shape = makeShape(startDrag.getX(), startDrag.getY(), event.getX(), event.getY());
      GraphicsContext gc = getGraphicsContext2D();
      gc.setStroke(color);
      drawShape(gc, shape);
    }
    startDrag = null;
    endDrag = null;
  }

  private void handleMouseDragged(MouseEvent event) {
    if (currentShapeType.equals("Freehand")) {
      currentLine.add(new Point(event.getX(), event.getY()));
    } else {
      endDrag = new Point(event.getX(), event.getY());
    }
    draw();
  }

  public void setCurrentShapeType(String type) {
    currentShapeType = type;
  }

  public String getCurrentShapeType() {
    return currentShapeType;
  }

  public void setStartDrag(Point point) {
    startDrag = point;
  }

  public Point getStartDrag() {
    return startDrag;
  }

  public void setEndDrag(Point point) {
    endDrag = point;
  }

  public Point getEndDrag() {
    return endDrag;
  }

  public void draw() {
    GraphicsContext gc = getGraphicsContext2D();
    gc.clearRect(0, 0, getWidth(), getHeight());

    for (Shape shape : model.getShapes()) {
      drawShape(gc, shape);
    }

    if (currentShapeType != null && !currentShapeType.equals("Freehand") && startDrag != null && endDrag != null) {
      Shape currentShape = makeShape(startDrag.getX(), startDrag.getY(), endDrag.getX(), endDrag.getY());
      if (!model.getShapes().contains(currentShape)) {
        drawShape(gc, currentShape);
      }
    }

    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    for (List<Point> line : lines) {
      for (int i = 0; i < line.size() - 1; i++) {
        Point p1 = line.get(i);
        Point p2 = line.get(i + 1);
        gc.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
      }
    }
  }

  private void drawShape(GraphicsContext gc, Shape shape) {
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);

    if (shape instanceof Line) {
      Line line = (Line) shape;
      gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
    } else if (shape instanceof Rectangle) {
      Rectangle rectangle = (Rectangle) shape;
      gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    } else if (shape instanceof Ellipse) {
      Ellipse ellipse = (Ellipse) shape;
      gc.strokeOval(ellipse.getCenterX() - ellipse.getRadiusX(), ellipse.getCenterY() - ellipse.getRadiusY(),
          ellipse.getRadiusX() * 2, ellipse.getRadiusY() * 2);
    } else if (shape instanceof Polygon) {
      Polygon polygon = (Polygon) shape;
      double[] xPoints = new double[polygon.getPoints().size() / 2];
      double[] yPoints = new double[polygon.getPoints().size() / 2];
      for (int i = 0; i < polygon.getPoints().size(); i += 2) {
        xPoints[i / 2] = polygon.getPoints().get(i);
        yPoints[i / 2] = polygon.getPoints().get(i + 1);
      }
      gc.strokePolygon(xPoints, yPoints, polygon.getPoints().size() / 2);
    }
  }

  public void startNewLine(double x, double y) {
    currentLine = new ArrayList<>();
    currentLine.add(new Point(x, y));
    lines.add(currentLine);
  }

  public void addPointToCurrentLine(double x, double y) {
    if (currentLine != null) {
      currentLine.add(new Point(x, y));
    }
  }

  public List<List<Point>> getLines() {
    return lines;
  }

  public MainModel getModel() {
    return model;
  }
}
