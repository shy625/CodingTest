/**
 * @ BJ 2475 검증수
 * @ prob : https://www.acmicpc.net/problem/2475
 */

import java.util.Scanner;

public class BJ_2475_검증수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int checkNum = 0;
        for(int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            checkNum += num * num;
        }
        System.out.println(checkNum % 10);

        sc.close();
    }
}