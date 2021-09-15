/**
 * @ BJ 2438 별 찍기 - 1
 * @ prob : https://www.acmicpc.net/problem/2438
 */

import java.util.Scanner;

public class BJ_2438_별찍기1 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 다른 방법 1
// 빈 문자열에 * 을 더해가면서 출력하는 방법

// String s = "";
// for(int i = 0; i < n; i++) {
//     System.out.println(s + "*");
// }