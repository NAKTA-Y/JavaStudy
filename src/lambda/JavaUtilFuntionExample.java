package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaUtilFuntionExample {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
        Consumer<Integer> c = (i) -> System.out.printf(i + " ");
        Predicate<Integer> p = (i) -> i % 2 == 0;
        Function<Integer, Double> f = (i) -> ((double)i/12.0*15.0)/10.0 * 10.0;

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Double> doubleList = doSomething(f, list);
        System.out.println(doubleList);

        System.out.println("////////////////////////////////////////////////////////////////");

        // Predicate 결합
        Predicate<Integer> p1 = i -> i < 100;
        Predicate<Integer> p2 = i -> i < 200;
        Predicate<Integer> p3 = i -> i % 2 == 0;

        Predicate<Integer> notP = p1.negate();
        Predicate<Integer> all = p1.and(p2).and(p3);
        Predicate<Integer> all2 = p1.and(p2.or(p3));

        System.out.println(all.test(2));
        System.out.println(all2.test(2));

        // 결합 예제
        Function<String, Integer> f1 = (s1) -> Integer.parseInt(s1, 16);
        Function<Integer, String> f2 = (i) -> Integer.toBinaryString(i);

        Function<String, String> h1 = f1.andThen(f2);
        Function<Integer, Integer> h2 = f1.compose(f2);

        System.out.println(h1.apply("FF"));
        System.out.println(h2.apply(2));

    }

    static <I, D> List<D> doSomething(Function<I, D> f, List<I> list) {
        List<D> newList = new ArrayList<>(list.size());

        for (I i : list) {
            newList.add(f.apply(i));
        }

        return newList;
    }

    static <I> void printEvenNum(Predicate<I> p, Consumer<I> c, List<I> list) {
        System.out.printf("[");
        for (I i : list) {
            if(p.test(i))
                c.accept(i);
        }
        System.out.printf("]\n");
    }

    static <I> void makeRandomList(Supplier<I> s, List<I> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
