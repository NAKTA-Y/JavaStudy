package collectionframework.collection;

import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        // Colection 구현 클래스를 유연하게 바꿀 수 있음
//        Collection list = new HashSet();
        Collection list = new ArrayList();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");

        Iterator it = list.iterator();

        while(it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
