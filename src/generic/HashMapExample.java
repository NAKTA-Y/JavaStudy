package generic;

import java.util.HashMap;

class Score {
    int kor;
    int eng;
    int math;

    public Score(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public String toString() {
        return "Score{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                '}';
    }
}

public class HashMapExample {
    public static void main(String[] args) {
        // 뒤에 나오는 다이아몬드 내에서는 생략 가능
        HashMap<String, Score> map = new HashMap<>();
        map.put("JAVA", new Score(50, 60, 70));

        System.out.println(map);

        Score score = map.get("JAVA");

        System.out.println(score);
    }

}
