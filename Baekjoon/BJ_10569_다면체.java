/**
 * @ BJ 10569 다면체
 * @ prob : https://www.acmicpc.net/problem/10569
 */

import java.util.Scanner;

public class BJ_10569_다면체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(2-v+e);  // 오일러 지표
        }

        sc.close();
    }
}