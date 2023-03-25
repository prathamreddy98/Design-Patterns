package WordCount.util;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import WordCount.util.Results;
import WordCount.util.MyLogger;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    String kmwfpath = "KMostFrequentWords.txt";
    String scopath= "spellCheckOutput.txt";

    public void writekmfw(String wordIn,int wordcountIn)
    {
        try
        {
            FileWriter myWriter = new FileWriter(kmwfpath,true);
            myWriter.write(wordIn +": "+wordcountIn+"\n");
            myWriter.close();
        }
        catch (IOException e) 
        {
            MyLogger.writeMessage("Error in function writekmfw: ", MyLogger.DebugLevel.RESULTS);
            // System.out.println("An error occurred.");
            // e.printStackTrace();
        }
        finally{
            // write_err.close();
        }
    }


    public void writesco(String sent)
    {
        try
        {
            FileWriter myWriter = new FileWriter(scopath,true);
            myWriter.write(sent+"\n");
            myWriter.close();
        }
        catch (IOException e) 
        {
            MyLogger.writeMessage("Error in function writesco: ", MyLogger.DebugLevel.RESULTS);
            // System.out.println("An error occurred.");
            // e.printStackTrace();
        }
        finally{
            // write_err.close();
        }
    }
   
}