package util;

import java.util.Comparator;

public class MyComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Double num1 = (Double) o1;
        Double num2 = (Double) o2;
        return (num1 < num2 ? -1 : (num1 == num2 ? 0 : 1));
    }

}
