package WordCount.driver;
import java.util.ArrayList;
import java.util.Map;

import WordCount.MyArray.MyArrayList;
import WordCount.util.FileProcessor;
import WordCount.visit.KMostFrequentWordCount;
import WordCount.visit.SpellCheckVisitor;
import java.lang.Exception;
import WordCount.util.MyLogger;

public class Driver {

    public static String englishWords;

    public static void main(String[] args)
    {
        try
        {
        if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
        || args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

            System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
            System.exit(0);
            }
            String input_file = args[0];
            englishWords=args[1];
		    String k_most_no=args[2];

            FileProcessor fp= new FileProcessor();
            ArrayList<String> sentenceList =  fp.read_file(input_file);            

            MyArrayList myArrayList = new MyArrayList(sentenceList);
            KMostFrequentWordCount kMost = new KMostFrequentWordCount();
            SpellCheckVisitor spellCheck = new SpellCheckVisitor();
            myArrayList.accept(kMost, k_most_no);
            myArrayList.accept(spellCheck, k_most_no);
        }
        catch(Exception e)
        {
            MyLogger.writeMessage("Error in Drive code: "+e.getMessage(), MyLogger.DebugLevel.FILE_PROCESSOR);
        }
        finally
        {
            // do nothing
        }

    }
    
}
