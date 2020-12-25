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
import main.classes.Folder;
import main.Main;

import javax.swing.text.html.ImageView;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MainController {

    private Stage stage;

    //Handles opening the folderGui to
    public void folderGui(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Folder.fxml"));
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
}
