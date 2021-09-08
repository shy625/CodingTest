/**
 * @ BJ 2523 별 찍기 - 13
 * @ prob : https://www.acmicpc.net/problem/2523
 */

import java.util.Scanner;

public class BJ_2523_별찍기13 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}