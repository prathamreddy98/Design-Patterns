package WordCount.visit;

import WordCount.MyArray.MyArrayList;
import WordCount.strategy.InsensitiveStrategy;
import WordCount.strategy.SensitiveStrategy;
import WordCount.strategy.Strategy;

public class SpellCheckVisitor implements Visitor {
    
    Strategy senStrategy = new SensitiveStrategy();
    Strategy insenStrategy = new InsensitiveStrategy();

    @Override
    public void visit(MyArrayList myArrayList, String k_no) {
        senStrategy.execute(myArrayList);
        insenStrategy.execute(myArrayList);
    }

}
