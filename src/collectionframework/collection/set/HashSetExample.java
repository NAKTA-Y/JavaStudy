package collectionframework.collection.set;

import java.util.*;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person[" + name + ":" + age + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class HashSetExample {
    public static void main(String[] args) {
        Object[] objArr = {"1", "2", "3", "3", "4", "4"};
        Set set = new HashSet();

        // Object Array iterator
        for (Object o : objArr) {
            set.add(o);
        }

        System.out.println(set);

        Iterator it = set.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // 정렬
        List list = new LinkedList(set);
        Collections.sort(list);;
        Set set2 = new HashSet(list);
        System.out.println(list);

        Person p1 = new Person("A", 10);
        Person p2 = new Person("A", 20);
        Person p3 = new Person("A", 20);
        Person p4 = new Person("A", 20);
        Person p5 = new Person("A", 20);

        // 객체 저장
        set2.add(p1);
        set2.add(p2);
        set2.add(p3);
        set2.add(p4);
        set2.add(p5);

        System.out.println(set2);
    }
}