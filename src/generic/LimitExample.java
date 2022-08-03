package generic;

import java.util.ArrayList;

class Fruit implements Eatable{
    @Override
    public String toString() {
        return "Fruit";
    }
}
class Apple extends Fruit{}
class Grape extends Fruit{}
class Toy {}

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    ArrayList<T> getList() { return list; }

    //== static 멤버에 타입 변수 사용 불가 ==//
//    static T item;

    //== 타입 변수 생성 불가 ==//
//    T[] toArray() {
//        T[] tmpArr = new T[10];
//        return tmpArr;
//    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}

public class LimitExample {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // Error!
        Box<Toy> toyBox = new Box<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());

        appleBox.add(new Apple());

        grapeBox.add(new Grape());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(grapeBox);

    }
}
