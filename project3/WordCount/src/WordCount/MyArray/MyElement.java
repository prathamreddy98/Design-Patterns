package WordCount.MyArray;

import java.util.Iterator;

import WordCount.visit.Visitor;

public interface MyElement {
    public Iterator getIterator();
    public void accept(Visitor visitor, String k_no);
}
