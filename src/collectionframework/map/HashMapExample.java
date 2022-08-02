package collectionframework.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("myId", "1234");
        hashMap.put("asdf", "1111");
        hashMap.put("asdf", "1234");
    }
}
