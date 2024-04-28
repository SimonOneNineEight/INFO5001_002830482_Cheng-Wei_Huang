package info5100.number_recognition2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import info5100.number_recognition2.controller.*;
import info5100.number_recognition2.view.MainView;
import info5100.number_recognition2.model.MainModel;

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
    launch(args);
  }
}