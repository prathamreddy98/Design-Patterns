package WordCount.strategy;

import java.util.Iterator;
import java.util.Map;

import WordCount.MyArray.MyArrayList;
import WordCount.util.FileProcessor;
import WordCount.util.Results;
import WordCount.util.MyLogger;
import java.lang.Exception;

public class SensitiveStrategy implements Strategy {
    
    @Override
    public void execute(MyArrayList myArrayList) 
    {
    try
    {
        Iterator myArrayItr = myArrayList.getIterator();
        Results writerobj = new Results();

        Map<String, String> words = new FileProcessor().read_english_words();
        writerobj.writesco("Result for Case Sensitive Stratergy:");
        while(myArrayItr.hasNext()) {
            String sentence = (String)myArrayItr.next();
            for(Map.Entry<String, String> entry: words.entrySet()) {
                sentence = sentence.replaceAll(entry.getKey(), entry.getValue());
                // System.out.println(sentence);
            }
            // System.out.println(sentence);
            writerobj.writesco(sentence);
        }

        // System.out.println("\n\n");
    }
    catch(Exception e)
    {
        MyLogger.writeMessage("Error in function execute for Sensitive Stratergy: "+e.getMessage(), MyLogger.DebugLevel.STRATERGY);
    }
    finally
    {
        // do nothing for now.
    }
    }
}
