/**
 * @ BJ 2748 피보나치 수 2
 * @ prob : https://www.acmicpc.net/problem/2748
 */

import java.util.Scanner;

public class BJ_2748_피보나치수2 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        long f0 = 0, f1 = 1, f2 = 1;
        for(int i = 0; i <= n; i++) {
            if(i == 0) {
                f2 = f0;
            } else if(i == 1) {
                f2 = f1;
            } else {
                f2 = f0 + f1;
                f0 = f1;
                f1 = f2;
            }
        }

        System.out.println(f2);
    }
}

// 다른 풀이 1
// 재귀함수 사용

// static long fibonacci(int n) {
//     return n == 0 ? 0 : (n == 1 ? 1 : (fibonacci(n-1) + fibonacci(n-2)));
// }