package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.File;

public class Main extends Application{

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Init Settings
        int width = 300;
        int height = 275;
        String titleName = "Main Window";
        String buttonText = "Click Here";

        //Button
        button = new Button(buttonText);

        //Init
        //Skeleton GUI for testing ground
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setTitle(titleName);
        Scene primaryScene = new Scene(button);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        //Button Event Handler
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                System.out.println("It works");
            }
        });

        public static void main (String[]args){
            launch(args);
        }
    }
}