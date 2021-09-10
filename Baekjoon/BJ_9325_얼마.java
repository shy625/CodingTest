/**
 * @ BJ 9325 얼마?
 * @ prob : https://www.acmicpc.net/problem/9325
 */

import java.util.Scanner;

public class BJ_9325_얼마 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int s = sc.nextInt();
            int n = sc.nextInt();
            for(int j = 0; j < n; j++) {
                int q = sc.nextInt(), p = sc.nextInt();
                s += q * p;
            }
            System.out.println(s);
        }

        sc.close();
    }
}