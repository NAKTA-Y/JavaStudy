package stream;


// 스트림의 특징
// 스트림은 데이터 소스로부터 데이터를 읽기만할 뿐 변경하지 않는다.
// 스트림은 Iterator처럼 일회용이다. (최종연산을 하면 스트림은 닫힌다.)
// 최종 연산 전까지 중간연산이 수행되지 않는다 (지연된 연산)
// 스트림의 작업을 병렬로 처리 가능 (병렬 스트림)
// 오토박싱 & 언박싱의 비효율이 제거된 IntStream, LongStream, DoubleStream 등이 있음

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConstructExample {
    public static void main(String[] args) {
        // 스트림 생성
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> intStream = list.stream();
        intStream.forEach(System.out::println);

        Stream<String> strStream = Stream.of("a", "b", "c");
        strStream.forEach(System.out::println);

        String[] strArr = {"a", "b", "c", "d"};
        Stream<String> strStream2 = Stream.of(strArr);
        strStream2.forEach(System.out::println);

        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream0 = Arrays.stream(intArr);
//        System.out.println(intStream0.max());
//        System.out.println(intStream0.average());
        System.out.println(intStream0.count());

        Integer[] integerArr = {1, 2, 3, 4, 5};
        Stream<Integer> integerStream = Stream.of(integerArr);
        integerStream.forEach(System.out::println);

        System.out.println("////////////////////////////////////////////////////////////////");

        // 무한, 유한 스트림
        IntStream intStream1 = new Random().ints(); // 무한 난수 스트림
        IntStream intStream2 = new Random().ints(5);
        intStream1.limit(5).forEach(System.out::println); // limit으로 수를 제한하거나, 미리 지정해야함
        intStream2.forEach(System.out::println);

        IntStream range1 = IntStream.range(1, 5);// 1, 2, 3, 4
        IntStream range2 = IntStream.rangeClosed(1, 5);// 1, 2, 3, 4, 5

        // 람다식 iterate(), generate()
        Stream<Integer> iterStream = Stream.iterate(0, n -> n + 2); // Function
        iterStream.limit(10).forEach(System.out::println);

        Stream<Integer> genStream = Stream.generate(() -> 1); // Supplier
        genStream.limit(10).forEach(System.out::println);
    }
}
