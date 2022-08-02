package collectionframework.collection.list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {

        // construct
        ArrayList list1 = new ArrayList(10);
        list1.add(new Integer(5));
        list1.add(new Integer(4));
        list1.add(new Integer(2));
        list1.add(new Integer(0));
        list1.add(new Integer(1));
        list1.add(new Integer(3));

        // subList
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        System.out.println(list1);
        System.out.println(list2);

        // sort
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);

        System.out.println(list1.containsAll(list2));

        // add
        list2.add("B");
        list2.add("C");
        list2.add(3, "A");
        System.out.println(list2);

        // set
        list2.set(3, "AA");
        System.out.println(list2);

        // indexOf
        list1.add(0, "1");
        System.out.println(list1);
        System.out.println("index= " + list1.indexOf(1));
        System.out.println("index= " + list1.indexOf("1"));

        // remove
        list1.remove(1);              // index 1 위치를 삭제한다.
        list1.remove(new Integer(1)); // integer 1을 삭제한다.
        System.out.println(list1);

        // iter
        System.out.println("list1= " + list1);
        System.out.println("list2= " + list2);
        for (Object o : list1) {
            if (list2.contains(o)) {
                list2.remove(o);
            }
        }
        System.out.println(list2);
    }
}
