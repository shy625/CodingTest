/**
 * @ BJ 2522 별 찍기 - 12
 * @ prob : https://www.acmicpc.net/problem/2522
 */

import java.util.Scanner;

public class BJ_2522_별찍기12 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}