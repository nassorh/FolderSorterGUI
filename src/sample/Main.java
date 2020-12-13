package sample;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Main extends Application{
    Button button;
    File selectedDirectory;

    public static void main (String[]args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Init Settings
        int width = 300;
        int height = 275;
        String titleName = "Main Window";
        String buttonText = "Click Here";

        //File Chooser
        DirectoryChooser directoryChooser = new DirectoryChooser();

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

        button.setOnAction(e -> {
            selectedDirectory = directoryChooser.showDialog(primaryStage);
            Folder folder = new Folder(selectedDirectory);
            folder.fetchFiles();
            folder.printFiles();
        });
    }
}