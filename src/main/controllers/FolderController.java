package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import main.Main;
import main.classes.Folder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class FolderController {

    private Stage stage;

    public void home(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));
        Scene folder = new Scene(root);

        //Fetches the window
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }

    public void setting(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Setting.fxml"));
        Scene folder = new Scene(root);

        //Fetches the window
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }

    public void selectFolder(MouseEvent mouseEvent) throws IOException{

        //Opens the new scene
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/FolderDetails.fxml"));
        Scene folder = new Scene(root);
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }

}
