package generic;

class Apple2 extends Fruit {
    @Override
    public String toString() {
        return "Apple";

    }
}
class Grape2 extends Fruit {
    @Override
    public String toString() {
        return "Grape";
    }
}

class Juice {
    String name;

    public Juice(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Juicer {
//    static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
//        String tmp = "";
//
//        for (T fruit : box.getList()) {
//            tmp += fruit + ", ";
//        }
//        return new Juice(tmp);
//    }

    static Juice makeJuice(FruitBox<? extends Fruit> box) {
        String tmp = "";

        for (Fruit fruit : box.getList()) {
            tmp += fruit + ", ";
        }
        return new Juice(tmp);
    }
}

public class WildCardExample {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple2> apple2Box = new FruitBox<>();
        FruitBox<Grape2> grape2Box = new FruitBox<>();

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple2());
        fruitBox.add(new Grape2());

        apple2Box.add(new Apple2());

        grape2Box.add(new Grape2());

        Juice juice1 = Juicer.makeJuice(fruitBox);
        Juice juice2 = Juicer.makeJuice(apple2Box);
        Juice juice3 = Juicer.makeJuice(grape2Box);

        System.out.println(juice1);
        System.out.println(juice2);
        System.out.println(juice3);
    }
}
