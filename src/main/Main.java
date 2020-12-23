package main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.File;


public class Main extends Application{
    public static Window primaryStage;
    Button button;
    File selectedDirectory;

    public static void main (String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Init Settings
        int width = 1024;
        int height = 600;
        String titleName = "Main Window";

        //Init
        //Fxml import
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Main.fxml"));
        primaryStage.setResizable(false);//Stop the resizing
        primaryStage.initStyle(StageStyle.UNDECORATED);//Removes the top bar
        primaryStage.setTitle(titleName);
        primaryStage.setScene(new Scene(root,width,height));
        primaryStage.show();


    }
}