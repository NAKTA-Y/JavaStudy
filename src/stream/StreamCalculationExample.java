package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Student implements Comparable<Student> {

    private String name;
    private int classNum;
    private int score;

    public Student(String name, int classNum, int score) {
        this.name = name;
        this.classNum = classNum;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNum=" + classNum +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getClassNum() {
        return classNum;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student student) {
        return student.getScore() - this.score;
    }
}

public class StreamCalculationExample {
    public static void main(String[] args) {
        // 스트림 중간 연산 (0 ~ n번 가능)
        // 스트림 자르기
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.skip(3).limit(5).forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        // 스트림 요소 걸러내기
        IntStream intStream1 = IntStream.of(1, 2, 2, 3, 3, 4, 5, 5, 6);
        intStream1.distinct().forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        intStream2.filter(i -> i % 2 == 0).forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        IntStream intStream3 = IntStream.rangeClosed(1, 20);
        intStream3.filter(i -> i % 2 == 0 && i % 3 == 0).forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        // 스트림 정렬 (정렬 대상, 정렬 기준)
        Stream<Student> studentStream = Stream.of(
                            new Student("A", 3, 300),
                            new Student("B", 1, 200),
                            new Student("C", 2, 100),
                            new Student("D", 1, 150),
                            new Student("E", 3, 200)
        );
        studentStream.sorted(Comparator.comparing(Student::getClassNum)
                .thenComparing(Comparator.naturalOrder()).reversed())
                .forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        // 스트림 요소 변환하기 (map)
        Stream<Student> studentStream2 = Stream.of(
                new Student("A.jpg", 3, 300),
                new Student("B.bak", 1, 200),
                new Student("C.jpg", 2, 100),
                new Student("D.wav", 1, 150),
                new Student("E.mp4", 3, 200)
        );

        Stream<String> stringStream = studentStream2.map(Student::getName);
        stringStream.filter(s -> s.indexOf('.') != -1)
                .map(s -> s.substring(s.indexOf('.')+1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);

        System.out.println("//////////////////////////////////////////////////////////");

        // 중간 결과 확인 (peek)
        Stream<Student> studentStream3 = Stream.of(
                new Student("A.jpg", 3, 300),
                new Student("B.bak", 1, 200),
                new Student("C.jpg", 2, 100),
                new Student("D.wav", 1, 150),
                new Student("E.mp4", 3, 200)
        );

        Stream<String> stringStream2 = studentStream3.map(Student::getName);
        stringStream2.filter(s -> s.indexOf('.') != -1)
                .peek(s -> System.out.println("filename= " + s))
                .map(s -> s.substring(s.indexOf('.')+1))
                .peek(s -> System.out.println("extensions= " + s))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);

        //스트림의 스트림을 스트림으로 변환 (flatMap)
        Stream<String[]> strArrStrm = Stream.of(
                new String[]{"abc", "def", "jkl"},
                new String[]{"ABC", "GHI", "JKL"}
        );

        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        String[] linkArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(linkArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("/////////////////////////////////////////////////////////////////////////");

        ///////////////////////////////////////////////////////////////////////////////
        // 최종 연산

        String[] strArr = {
                "Java", "Lambda", "Stream", "OptionalDouble",
                "IntStream", "count", "sum", "max", "min"
        };

        Stream.of(strArr)
                .parallel()
                .forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
        Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println(noEmptyStr);
        System.out.println(sWord.get());

        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream5 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream6 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream7 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream4.reduce(0, (a, b) -> a + 1);
        int sum = intStream5.reduce(0, (a, b) -> a + b);

        OptionalInt max = intStream6.reduce(Integer::max);
        OptionalInt min = intStream7.reduce(Integer::min);

        System.out.println(count);
        System.out.println(sum);
        System.out.println(max.getAsInt());
        System.out.println(min.getAsInt());
    }
}