package WordCount.util;
import java.io.FileWriter;
import java.io.IOException;

import java.io.File;
import java.io.PrintWriter;
import WordCount.util.MyLogger;
import java.lang.Exception;

public class ClearFiles {
 
    /**
     * Function to clear text files 
     * It takes a filepath as a parameter, creates a new file object, creates a new printwriter object,
     * and then writes an empty string to the file
     * 
     * @param filepath The path to the file you want to clean.
     */
    public void clean_files(String filepath)
    {
    try
    {
    File file = new File(filepath);
    PrintWriter writer = new PrintWriter(file);
    writer.print("");
    writer.close();
    }
    catch(IOException e)
    {
        MyLogger.writeMessage("Error in function read_file : "+e.getMessage(), MyLogger.DebugLevel.FILE_PROCESSOR);
    }
    finally
    {
        //do nothing
    }
    
    }
}
