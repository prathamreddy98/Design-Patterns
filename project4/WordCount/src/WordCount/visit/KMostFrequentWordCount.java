package WordCount.visit;

import WordCount.MyArray.MyArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import WordCount.util.Results;
import WordCount.util.MyLogger;
import java.lang.Exception;

public class KMostFrequentWordCount implements Visitor {
    

    @Override
    public void visit(MyArrayList myArrayList, String k_no) 
    {
        try
        {
        Results writerobj = new Results();

        Iterator itr = myArrayList.getIterator();

        ArrayList<Item> listOfWords = new ArrayList<>();

        HashMap<String, Item> wordsDic = new HashMap<>();

        PriorityQueue que = new PriorityQueue<Item>(new CountComparator());

        while(itr.hasNext()) 
        {
            String lineString = (String)itr.next();
            //System.out.println(lineString);
           String[] sentence_break = lineString.split(" ");
           for(int i=0;i<sentence_break.length-1; i++) {
                String word = sentence_break[i].trim();
                if(wordsDic.containsKey(word)) {
                    Item wordItem = wordsDic.get(word);
                    wordsDic.remove(word);
                    wordItem.count++;
                    wordsDic.put(word, wordItem);
                } else {
                    Item wordItem = new Item(word, 1);
                    wordsDic.put(word, wordItem);
                }

                
           }        

        }
        for(String word: wordsDic.keySet()) 
        {
            Item wrdItem = wordsDic.get(word);
            que.offer(wrdItem);
        }


        Iterator queItr = que.iterator();

        int counting = 0;
        int k_number = Integer.parseInt(k_no);
        
        // for writing K most frequent words in Results.java
        // Results writerobj = new Results();
        
        while(queItr.hasNext()) 
        {
            if(counting < k_number) {
                Item itt = (Item)que.poll();
                // System.out.println(itt.word +": "+itt.count);
                writerobj.writekmfw(itt.word,itt.count);
                // writekmfw(itt.word,itt.count);
                counting++;
                
            } else {
                break;
            }
        }
        }
        catch(Exception e)
        {
            MyLogger.writeMessage("Error in function visit: "+e.getMessage(), MyLogger.DebugLevel.VISITOR);
        }
        finally
        {
            // do nothing for now.
        }

    }
}
