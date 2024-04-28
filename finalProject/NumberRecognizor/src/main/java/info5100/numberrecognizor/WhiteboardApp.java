package info5100.numberrecognizor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import info5100.numberrecognizor.controller.*;
import info5100.numberrecognizor.view.MainView;
import info5100.numberrecognizor.model.MainModel;

public class WhiteboardApp extends Application {

  public static MainModel model;
  public static MainView view;
  public static MainController controller;

  @Override
  public void start(Stage primaryStage) {
    model = new MainModel();
    view = new MainView(model);
    controller = new MainController(model, view);


    Scene scene = new Scene(view, 800, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("My Whiteboard");
    primaryStage.show();
  }

  public static void main(String[] args) {
    String classpath = System.getProperty("java.class.path");
    System.out.println("Classpath:");
    System.out.println(classpath);
    launch(args);
  }
}