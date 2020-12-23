package main.controllers;

import javafx.stage.DirectoryChooser;
import main.classes.Folder;
import main.Main;

import java.io.File;
import java.util.HashMap;


public class Controller {
    Folder folder;
    int state = 0; //0 = catergory 1 = alphabet 2 = Size 3 = Date
    HashMap<String, Integer> catergoryAmount = new HashMap<String, Integer>();

    public void startUp(){
        //Fetch the directory
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(Main.primaryStage);

        //Class init
        folder = new Folder(selectedDirectory);

        //Fetch all the folders
        folder.fetchFiles();
        for (File file : folder.files){
            String extension = folder.fetchExtension(file);
            String catergory = folder.fetchCatergory(extension);

            //Checking if word exists in the dictontary
            Integer count = catergoryAmount.get(catergory);
            if(count == null){
                catergoryAmount.put(catergory,1);
            }else{
                catergoryAmount.put(catergory,count+1);
            }
        }
    }
}
