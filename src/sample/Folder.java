package sample;

import java.io.File;
import java.util.ArrayList;

public class Folder {
    File directory;
    ArrayList<File> files = new ArrayList<File>();

    //Constructor for initialise the directory path
    public Folder(File directory) {
        this.directory = directory;
        System.out.println("Object Created");
    }

    public void fetchFiles() {
        File[] folder = directory.listFiles();
        for (int i = 0; i < folder.length; i++) {
            files.add(folder[i]);
        }
        System.out.println("Files fetched");
    }
    public String fetchExtension(File file){
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf==-1){
            return ""; //empty extension
        }
        return name.substring(lastIndexOf);
    }
    public void sortFile(){

    }

    public void printFiles(){
        System.out.println("Printing files...");
        for (int i = 0; i<files.size();i++){
            System.out.print(fetchExtension(files.get(i))); //Get file name "files.get(i).getName()"
        }
    }
}