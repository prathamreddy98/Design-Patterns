package WordCount.MyArray;

import java.util.ArrayList;
import java.util.Iterator;

import WordCount.visit.Visitor;

public class MyArrayList implements MyElement {
    
    public ArrayList<String> sentences = new ArrayList<>();

    public MyArrayList(ArrayList<String> sentencesList) {
        sentences = sentencesList;
    }

    public Iterator getIterator() {
        Iterator itr = sentences.iterator();

        return itr;
    }

    public void accept(Visitor visitor, String k_no) {
        visitor.visit(this, k_no);
    }



}
