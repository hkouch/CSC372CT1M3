package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CT1M3 extends Application {
    private TextArea outputTextArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Interface Example");

        BorderPane root = new BorderPane();

        //Create a menu
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");

        //Menu Items
        MenuItem item1 = new MenuItem("Date & Time");
        MenuItem item2 = new MenuItem("Save to file");
        MenuItem item3 = new MenuItem("Change Color");
        MenuItem item4 = new MenuItem("Exit");

        //Assign actions/methods to menu items
        item1.setOnAction(event -> printTime());
        item2.setOnAction(event -> writeToFile());
        item3.setOnAction(event -> changeBGcolor());
        item4.setOnAction(event -> System.exit(0));

        // Add menu items to the menu
        menu.getItems().addAll(item1, item2, item3, item4);

        //Add menu to the menu bar
        menuBar.getMenus().add(menu);

        //Create text area
        outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        //Add components to the main pane
        root.setTop(menuBar);
        root.setCenter(outputTextArea);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Display current date and time in the TextArea
    private void printTime() {
        String dateTime = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(new Date());
        outputTextArea.appendText("Date and Time: " + dateTime + "\n");
    }

    //Write contents of the TextArea to a file
    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(outputTextArea.getText());
            writer.newLine();
            outputTextArea.appendText("Contents written to log.txt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Change the background color of the TextArea
    private void changeBGcolor() {
        Random random = new Random();
        // Generate a random green hue(~60-180)
        double hue = 60 + random.nextDouble() * 120;
        Color randomColor = Color.hsb(hue, 1.0, 1.0); // Create color with random hue
        outputTextArea.setStyle("-fx-control-inner-background: #" + toRGBCode(randomColor) + ";");
        outputTextArea.appendText("Background color changed\n");
    }

    //Convert a Color to its RGB hexadecimal representation
    private String toRGBCode(Color color) {
        return String.format("%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
