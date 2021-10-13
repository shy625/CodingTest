/**
 * @BJ 2702 초6 수학
 * @ prob : https://www.acmicpc.net/problem/2702
 */

import java.util.Scanner;

public class BJ_2702_초6수학 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // int gcd = a >= b ? euclidean(a, b) : euclidean(b, a);   // a, b 대소 따져서 넣을 필요 없음.
            int gcd = euclidean(a, b);                                 // b > a 인 경우, a % b = a 이기 때문에 어차피 다음 반복에서 자동으로 바뀌어 b % a로 계산
            int lcm = a * b / gcd;
            System.out.println(lcm + " " + gcd);
        }

        sc.close();
    }

    static int euclidean(int a, int b) {
        int r = 0;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

// 다른 풀이 1
// 유클리트 호제법을 재귀로 구현

// static int euclidean(int a, int b) {
//     if(b == 0) {
//         return a;
//     }
//     return euclidean(b, a % b);
// }