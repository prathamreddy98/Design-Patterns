package WordCount.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import WordCount.driver.Driver;

import java.io.File;
import WordCount.util.ClearFiles;
import WordCount.util.MyLogger;

public class FileProcessor {
   public ArrayList<String> read_file(String input){
    // ClearFiles.ClearData(outputFile, error_file);
    // ClearFiles.ClearData(error_file, error_file);


    // Clean the output files here.
    String kmwfpath = "KMostFrequentWords.txt";
    String scopath = "spellCheckOutput.txt";
    ClearFiles clean_txt_files=new ClearFiles();
    clean_txt_files.clean_files(kmwfpath);
    clean_txt_files.clean_files(scopath);

    ArrayList<String> sentenceList = new ArrayList<>();

    try{

        String temp;
        File f=new File(input);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){

            temp = sc.nextLine(); 
            //System.out.println(temp);
            sentenceList.add(temp);
        }
        sc.close();
    }
    catch(Exception e){
        // System.out.println("error");
        MyLogger.writeMessage("Error in function read_file : "+e.getMessage(), MyLogger.DebugLevel.FILE_PROCESSOR);
    }
    finally{
        // System.out.println("Finally block");
        // Close conneciton here
    }

    return sentenceList;

   }
   
   
   public Map<String,String> read_english_words() {
        Map<String,String> words = new HashMap<>();

        try{

            String temp;
            File f=new File(Driver.englishWords);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()){

                temp = sc.nextLine(); 

                String[] arrWords = temp.split(":");
                //System.out.println(temp);
                words.put(arrWords[0], arrWords[1]);
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("error");
            MyLogger.writeMessage("Error in function read_english_words : "+e.getMessage(), MyLogger.DebugLevel.FILE_PROCESSOR);
        }
        finally{
            // System.out.println("Finally block");
            // close here if need to close connection or socket or db.
        }
        //System.out.println(words);

        return words;

   }
}
