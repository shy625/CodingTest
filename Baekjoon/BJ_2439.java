/**
 * @ BJ 2439 별 찍기 - 2
 * @ prob : https://www.acmicpc.net/problem/2439
 */

import java.util.Scanner;

public class BJ_2439 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        String s = "";
        for(int i = 0; i < n; i++) {
            System.out.printf("%" + n + "s\n", s += "*");
        }
    }
}

// 다른 방법 1
// 반복문 사용하여 " "과 "*" 출력

// for(int i = 1; i <= n; i++) {
//     for(int j = n-i; j > 0; j--) {
//         System.out.print(" ");
//     }
//     for(int k = 1; k <= i; k++) {
//         System.out.print("*");
//     }
//     System.out.println();
// }