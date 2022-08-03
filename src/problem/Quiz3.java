package problem;

import java.util.Scanner;

public class Quiz3 {
    static int betweenSum(int from, int to) {
        if (from == to) {
            return to;
        }
        return from + betweenSum(from + 1, to);
    }

    public static void main(String[] args) {
//        변수 n1과 n2에 값을 넣고 n1과 n2사이의 합을 계산하여 그 결과를 출력하는 프로그램을 작성.
//        예를들어 2와 5를 입력받으면, 2 + 3 + 4 + 5의 연산결과인 14를 출력해야 한다.

//        단, 5와 2 처럼 큰 수를 먼저 입력받아도 같은 결과가 나와야 함

        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();

        if (from > to) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        System.out.println(betweenSum(from, to));
    }
}
