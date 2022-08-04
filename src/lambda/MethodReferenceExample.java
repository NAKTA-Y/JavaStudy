package lambda;

import java.util.function.Function;
import java.util.function.Supplier;

class MyClass {
    int iv;

    public MyClass(){}
    public MyClass(int iv) {
        this.iv = iv;
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 메서드 참조
        Function<String, Integer> f = Integer::parseInt;
        Function<String, Integer> f2 = s -> Integer.parseInt(s);

        System.out.println(f.apply("16").getClass());
        System.out.println(f2.apply("16").getClass());

        // 생성자와 메서드 참조
        Supplier<MyClass> s = MyClass::new;
        MyClass cls = s.get();

        System.out.println(cls.toString());

        // 멤버 변수
        Function<Integer, MyClass> f3 = MyClass::new;

        System.out.println(f3.apply(15).iv);

        // 배열
        Function<Integer, Integer[]> f4 = Integer[]::new;
        Function<Integer, Integer[]> f5 = (i) -> new Integer[i];
        Integer[] arrayTest = f4.apply(10);
        Integer[] arrayTest2 = f5.apply(10);

        System.out.println(arrayTest.length);
        System.out.println(arrayTest2.length);
    }
}
