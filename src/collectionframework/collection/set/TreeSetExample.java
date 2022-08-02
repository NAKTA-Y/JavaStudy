package collectionframework.collection.set;

import com.sun.source.util.Trees;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set set = new TreeSet(new TestComp());

        for (int i = 0; i < 6; i++) {
            int num = (int)(Math.random() * 40) + 1;
            set.add(num);
        }

        System.out.println(set);

        ////////////////////////////////////////////////////////////////////////////////

        TreeSet set2 = new TreeSet(String.CASE_INSENSITIVE_ORDER);

        String from = "b";
        String to = "d";

        set2.add("abc");     set2.add("alien");       set2.add("bat");
        set2.add("car");     set2.add("Car");         set2.add("disc");
        set2.add("dance");   set2.add("dZZZZZ");      set2.add("dzzzzz");
        set2.add("elephant");

        System.out.println(set2);
        System.out.println("range search: from " + from + " to " + to);
        System.out.println("result1: " + set2.subSet(from, to));
        System.out.println("result1: " + set2.subSet(from, "dzzzzz"));

        ////////////////////////////////////////////////////////////////////////////////

        TreeSet set3 = new TreeSet();
        int[] score = {10, 20, 45, 35, 68, 49 , 76, 40, 80, 50};

        for (int i : score) {
            set3.add(i);
        }

        System.out.println("50보다 작은 값: " + set3.headSet(50));
        System.out.println("50보다 큰 값: " + set3.tailSet(50));
        System.out.println("40과 80사이의 값: " + set3.subSet(40, 80));
    }
}

class TestComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2);
        }
        return -1;
    }
}
