package lambda;

import java.util.*;

// 함수형 인터페이스
@FunctionalInterface
interface MyFuntion1 {
    public abstract int max(int a, int b);
}

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

@FunctionalInterface
interface MyFunction3 {
    void run();
}

public class LambdaExample {
    public static void main(String[] args) {

        // 람다식은 익명 객체
        MyFuntion1 f = (a, b) -> a > b ? a : b;

        System.out.println(f.max(10, 4));

        ////////////////////////////////////////////////////////////////////////////////////////////

        List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");

        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        System.out.println(list);

        ////////////////////////////////////////////////////////////////////////////////////////////

        MyFunction2 f2 = () -> System.out.println("myMethod()");
        f2.myMethod();

        ////////////////////////////////////////////////////////////////////////////////////////////

        MyFunction3 f3 = () -> System.out.println("f3.run()");

        MyFunction3 f4 = new MyFunction3() {
            @Override
            public void run() {
                System.out.println("f4.run()");
            }
        };

        MyFunction3 f5 = getMyFunction();

        f3.run();
        f4.run();
        f5.run();

        execute(f3);
        execute(() -> System.out.println("run()"));
    }

    static void execute(MyFunction3 f) {
        f.run();
    }

    static MyFunction3 getMyFunction() {
        MyFunction3 f = () -> System.out.println("f.run()");
        return f;
    }
}
