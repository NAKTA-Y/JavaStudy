package problem;

import java.util.Scanner;

public class Quiz2 {
    static int consecutiveSum(int key) {
        if (key <= 0)
            return 0;
        return key + consecutiveSum(key - 1);
    }

    public static void main(String[] args) {
//        변수 n에 정수값을 저장하고 1부터 입력받은 정수 n까지의 합을 계산하여
//        그 결과를 출력하는 프로그램을 작성.
//                예를들어 정수 5를 입력받으면,
//        1 + 2 + 3 + 4 + 5의 연산결과인 15를 출력해야 한다.

        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println(consecutiveSum(key));
    }
}
