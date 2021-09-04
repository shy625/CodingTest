/**
 * @ BJ 2438 별 찍기 - 1
 * @ prob : https://www.acmicpc.net/problem/2438
 */

import java.util.Scanner;

public class BJ_2438 {
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