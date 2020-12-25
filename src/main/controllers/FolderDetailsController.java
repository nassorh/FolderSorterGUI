package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import main.Main;
import main.classes.Folder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class FolderDetailsController implements Initializable {

    Folder folder;
    int state = 0; //0 = catergory 1 = alphabet 2 = Size 3 = Date
    public HashMap<String, Integer> catergoryAmount = new HashMap<String, Integer>();
    private Boolean filesFound = false;
    private Stage stage;

    @FXML private PieChart chart;

    public void initialize(URL url, ResourceBundle rb){
        //Fetches the data
        load();
        addDataToPieChart();
    }

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

    public void load(){
        //Fetch the directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(Main.primaryStage);

        //Class init
        folder = new Folder(selectedDirectory);

        //Fetch all the folders and finds how many files in each category
        if(folder.fetchFiles() ==0){
            for (File file : folder.files) {
                String extension = folder.fetchExtension(file);
                String catergory = folder.fetchCatergory(extension);

                //Checking if word exists in the dictontary
                Integer count = catergoryAmount.get(catergory);
                if (count == null) {
                    catergoryAmount.put(catergory, 1);
                } else {
                    catergoryAmount.put(catergory, count + 1);
                }
            }
        }else{
            System.out.println("Handle Error");
        }

    }
    public void addDataToPieChart(){
        //Piechart data
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        if(list.isEmpty()){
            list.add(new PieChart.Data("No Files Found",1));
        }else{
            //Adds data to the pieChart
            for(Map.Entry<String,Integer> data: catergoryAmount.entrySet()) {
                if (data.getKey().length() == 0) {
                    list.add(new PieChart.Data("Unsorted", data.getValue()));
                } else {
                    list.add(new PieChart.Data(data.getKey(), data.getValue()));
                }
            }
        }
        chart.setData(list);
    }

    public void sortFiles(ActionEvent actionEvent) {
        if(filesFound){
            //Make the folders
            for(Map.Entry<String,Integer> data: catergoryAmount.entrySet()){
                folder.makeFolder(data.getKey());
            }
            for (File file : folder.files){
                //Fetch the extension
                String extension = folder.fetchExtension(file);
                //Fetch the catergory
                String catergory = folder.fetchCatergory(extension);
                //Move the file
                if(catergory.length() == 0){
                    //Move the file to Miscellaneous
                    String fileDestination = folder.directory + "\\" + "Unsorted";
                    folder.moveFile(file.getPath(),fileDestination);
                }else{
                    String fileDestination = folder.directory + "\\" + catergory;
                    folder.moveFile(file.getPath(),fileDestination);
                }
            }
        }else{
            System.out.println("No files orgainsed");
        }

    }
}
