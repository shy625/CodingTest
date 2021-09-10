/**
 * @ BJ 10178 할로윈의 사탕
 * @ prob : https://www.acmicpc.net/problem/10178
 */

import java.util.Scanner;

public class BJ_10178_할로윈의사탕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int c = sc.nextInt();
            int v = sc.nextInt();

            System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", c/v, c%v);
        }

        sc.close();
    }
}