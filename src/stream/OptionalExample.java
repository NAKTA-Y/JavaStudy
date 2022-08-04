package stream;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalExample {
    public static void main(String[] args) {
        // 간접적으로 Null을 다루기 위한 래퍼 클래스
        // 널 체크가 필요없어짐 (코드 간결화)
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr= " + optStr.get());
        System.out.println("optInt= " + optInt.get());

        Integer result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();

        Integer result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println(result1);
        System.out.println(result2);

        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.println(x));

        OptionalInt optInt1 = OptionalInt.of(0);
        OptionalInt optInt2 = OptionalInt.empty();

        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());

        System.out.println(optInt1.getAsInt());
        System.out.println(optInt2.orElse(1));


    }
}
