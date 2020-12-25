package main.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import main.Main;
import main.classes.Folder;

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

    @FXML
    private PieChart chart;

    public void initialize(URL url, ResourceBundle rb){
        //Fetches the data
        load();

        //Piechart data
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        //Adds data to the pieChart
        for(Map.Entry<String,Integer> data: catergoryAmount.entrySet()){
            if(data.getKey().length() == 0){
                list.add(new PieChart.Data("Miscellaneous",data.getValue()));
            }else{
                list.add(new PieChart.Data(data.getKey(), data.getValue()));
            }
        }
        chart.setData(list);
    }


    public void load(){
        //Fetch the directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(Main.primaryStage);

        //Class init
        folder = new Folder(selectedDirectory);

        //Fetch all the folders and finds how many files in each category
        folder.fetchFiles();
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
    }
}
