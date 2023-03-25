package WordCount.visit;

import java.util.Comparator;

public class CountComparator implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
        if(i1.count == i2.count) {
            return 0;
        } else if(i1.count <i2.count) {
            return 1;
        } else {
            return -1;
        }
    }
}
