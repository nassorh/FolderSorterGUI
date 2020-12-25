package main.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class SettingController {

    private Stage stage;

    public void home(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));
        Scene folder = new Scene(root);

        //Fetches the window
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }

    public void folderGui(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Folder.fxml"));
        Scene folder = new Scene(root);

        //Fetches the window
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }


}
