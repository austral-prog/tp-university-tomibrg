package com.university.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InformationExtractor {

    public ArrayList<String[]> extractFileData(String inputPath){

        ArrayList<String[]> dataList = new ArrayList<String[]>();

        try (BufferedReader inputReader = new BufferedReader(new FileReader(inputPath))){
            String inputLine;

            while((inputLine = inputReader.readLine()) != null){
                String[] lineList = inputLine.split(",");
                dataList.add(lineList);

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        dataList.removeFirst();
        return dataList;
    }
}
