/**
 * @ BJ 5596 시험 점수
 * @ prob : https://www.acmicpc.net/problem/5596
 */

import java.util.Scanner;

public class BJ_5596_시험점수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minSum = 0;
        int manSum = 0;

        for(int i = 0; i < 4; i++) {
            minSum += sc.nextInt();
        }
        for(int i = 0; i < 4; i++) {
            manSum += sc.nextInt();
        }

        System.out.println(minSum >= manSum ? minSum : manSum);

        sc.close();
    }
}