/**
 * @ BJ 2010 플러그
 * @ prob : https://www.acmicpc.net/problem/2010
 */

import java.util.Scanner;

public class BJ_2010_플러그 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum-(n-1));

        sc.close();
    }
}