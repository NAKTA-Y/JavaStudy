package collectionframework.collection.list;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add(2);

        linkedList.add(1, "3");

        // LinkedList는 ArrayList 보다 중간 추가, 삭제가 훨씬 빠름
        System.out.println(linkedList);
    }
}
