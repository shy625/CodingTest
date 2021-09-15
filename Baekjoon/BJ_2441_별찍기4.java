/**
 * @ BJ 2441 별 찍기 - 4
 * @ prob : https://www.acmicpc.net/problem/2441
 */

import java.util.Scanner;

public class BJ_2441_별찍기4 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = n; i > 0; i--) {
            String s = "";
            for(int j = 0; j < i; j++) {
                s += "*";
            }
            System.out.printf("%" + n + "s\n", s);
        }
    }
}

// 다른 방법 1
// 삼항연산자 이용

// for(int i = 0; i < n; i++) {
//     for(int j = 0; j < n; j++) {
//         System.out.print(i > j ? " " : "*");
//     }
//     System.out.println();
// }

// 다른 방법 2
// repeat() 이용 (jdk11 이상)

// for(int i = 0; i < n; i++) {
//     System.out.printf(" ".repeat(i) + "*".repeat(n-i));
// }