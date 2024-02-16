package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            //Create a BorderPane as the root layout
            BorderPane root = new BorderPane();

            //Create a Scene with the BorderPane and set its dimensions
            Scene scene = new Scene(root, 400, 400);

            //Add an external CSS stylesheet to the Scene
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            //Set the Scene to the primaryStage
            primaryStage.setScene(scene);

            //Show the primaryStage
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //The main method, which launches the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}