/**
 * @ BJ 10992 별 찍기 - 17
 * @ prob : https://www.acmicpc.net/problem/10992
 */

import java.util.Scanner;

public class BJ_10992_별찍기17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < 2*i-3; j++) {
                System.out.print(" ");
            }
            System.out.print(i == 1 ? "\n" : "*\n");
        }
        for (int i = 0; i < 2*n-1; i++) {
            System.out.print("*");
        }

        sc.close();
    }
}
// 다른 풀이 1
// 한 반복문 안에서 조건에 따라 "*" 또는 " " 을 출력
// https://www.acmicpc.net/source/8935788
// https://www.acmicpc.net/source/11886745
// https://www.acmicpc.net/source/18015104

// 다른 풀이 2
// jdk11 repeat() 이용
// https://www.acmicpc.net/source/32234032