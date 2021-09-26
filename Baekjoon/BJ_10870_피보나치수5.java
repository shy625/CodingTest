/**
 * @ BJ 10870 피보나치 수 5
 * @ prob : https://www.acmicpc.net/problem/10870
 */

import java.util.Scanner;

public class BJ_10870_피보나치수5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int f0 = 0, f1 = 1, f2 = 1;
        for(int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        // System.out.println(n == 0 ? f0 : (n == 1 ? f1 : f2));
        System.out.println(n < 2 ? n : f2);

        sc.close();
    }
}