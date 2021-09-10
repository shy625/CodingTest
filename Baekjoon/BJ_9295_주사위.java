/**
 * @ BJ 9295 주사위
 * @ prob : https://www.acmicpc.net/problem/9295
 */

import java.util.Scanner;

public class BJ_9295_주사위 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            System.out.printf("Case %d: %d\n", i, sc.nextInt()+sc.nextInt());
        }

        sc.close();
    }
}