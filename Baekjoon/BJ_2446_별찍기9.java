/**
 * @ BJ 2446 별 찍기 - 9
 * @ prob : https://www.acmicpc.net/problem/2446
 */

import java.util.Scanner;

public class BJ_2446_별찍기9 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i-1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*(n-i)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i-1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*(n-i)+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}