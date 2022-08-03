package problem;

public class Quiz1 {
    public static void main(String[] args) {
//        배, 사과, 오렌지를 키우고 있는데 각 과일의 하루 생산량은 각각 5, 6, 7개
//        1)과수원에서 하루에 생산되는 과일의 총 갯수를 출력
//        2)시간당 과일의 생산 갯수를 출력
//
//        단, 과일의 갯수를 저장하는 변수는 int타입으로
//        하루에 생산되는 과일의 총 갯수를 저장하는 변수도 int타입으로
//        시간당 생산 갯수를 저장할 변수는 float타입으로 작성할 것.

        int appleDailyProduction = 6;
        int bearDailyProduction = 5;
        int orangeDailyProduction = 7;

        int fruitDailyProduction = 0;
        float fruitHourProduction = 0.0f;

        fruitDailyProduction = appleDailyProduction + bearDailyProduction + orangeDailyProduction;
        fruitHourProduction = fruitDailyProduction / 24f;

        System.out.println("1) 하루에 생산되는 과일의 총 갯수 = " + fruitDailyProduction);
        System.out.println("2) 시간당 생산되는 과일의 갯수 = " + fruitHourProduction);
    }
}
