package generic;

import java.util.ArrayList;
import java.util.Iterator;

class Student {
    String name = "";
    int id;
    int classNum;

    public Student(String name, int id, int classNum) {
        this.name = name;
        this.id = id;
        this.classNum = classNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", classNum=" + classNum +
                '}';
    }
}

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("JAVA", 1, 1));
        list.add(new Student("PYTHON", 2, 2));
        list.add(new Student("C++", 3, 3));

        Iterator<Student> it = list.iterator();

        while(it.hasNext()) {
            Student student = it.next();
            System.out.println(student);
        }
    }
}
