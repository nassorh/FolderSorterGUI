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
    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
    File selectedDirectory;

    @FXML private PieChart chart;


    public void initialize(URL url, ResourceBundle rb){
        //Fetch the directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        selectedDirectory = directoryChooser.showDialog(Main.primaryStage);

        //Class init

        //Fetches the data
        if(load(selectedDirectory)==0){
            if(addDataToPieChart(catergoryAmount) != 0){
                System.out.println("Display an error not being able to display the piechart");
            }
        }else{
            System.out.println("Display an error with files not being able to be fetched ");
        }

    }

    public void home(MouseEvent mouseEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/Main.fxml"));
        Scene folder = new Scene(root);

        //Fetches the window
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(folder);
        stage.show();
    }

    public void folderGUI(MouseEvent mouseEvent) throws IOException{
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

    public int load(File folderDirectory){
        //Test if the directory exists
        try{
            folder = new Folder(folderDirectory);
            if(folder.fetchFiles() ==0){
                for (File file : folder.files) {
                    String extension = folder.fetchExtension(file);//Fetch the extension
                    String catergory = folder.fetchCatergory(extension);//Find the catergory
                    Integer count = catergoryAmount.get(catergory);//Checking if catergory exists in the catergoryDict
                    if (count == null) {
                        catergoryAmount.put(catergory, 1);//If the catergory does not exists add to the catergoyDict
                    } else {
                        catergoryAmount.put(catergory, count + 1);//If the catergory exists increment the file number
                        // by one
                    }
                }
                return 0;
            }else{
                list.clear();
                list.add(new PieChart.Data("No Files Found",1));
                chart.setData(list);//An error that no files were found needs to be
                // added here
                filesFound = false;
                return -1;
            }
        }catch (Exception e){
            //Directory does not exist
            System.out.println(e);
            return -1;
        }



    }
    public int addDataToPieChart(HashMap<String, Integer> dict){
        try{
            //Clears the list
            list.clear();
            //Piechart data
            if(dict.isEmpty()){
                list.add(new PieChart.Data("No Files Found",1));//No files exist in the folder error needs be added here
                filesFound = false;
            }else{
                filesFound = true;
                //Adds data to the pieChart
                for(Map.Entry<String,Integer> data: dict.entrySet()) {
                    if (data.getKey().length() == 0) {
                        list.add(new PieChart.Data("Unsorted", data.getValue()));
                    } else {
                        list.add(new PieChart.Data(data.getKey(), data.getValue()));
                    }
                }
            }
            chart.setData(list);
        }catch (Exception e){
            return -1;
        }
        return 0;
    }

    public int sortFiles(ActionEvent actionEvent) {
        //Sort files
        if(filesFound){
            //Make the folders
            for(Map.Entry<String,Integer> data: catergoryAmount.entrySet()){
                if(folder.makeFolder(data.getKey()) == -1){System.out.println("Add an error that the folder could " +
                        "not be maid"); return -1;}
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
            return -1;
        }
        //Rescan
        if(load(selectedDirectory)==0){
            if(addDataToPieChart(catergoryAmount) != 0){
                System.out.println("Display an error not being able to display the piechart");
            }
        }else{
            System.out.println("Display an error with files not being able to be fetched ");
        }

        return 0;
    }

    public void newFolder(ActionEvent actionEvent) {
        //Fetch the directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        selectedDirectory = directoryChooser.showDialog(Main.primaryStage);

        //Class init

        //Fetches the data
        if(load(selectedDirectory)==0){
            if(addDataToPieChart(catergoryAmount) != 0){
                System.out.println("Display an error not being able to display the piechart");
            }
        }else{
            System.out.println("Display an error with files not being able to be fetched ");
        }

    }
}
