/**
 * @ BJ 2444 별 찍기 - 7
 * @ prob : https://www.acmicpc.net/problem/2444
 */

import java.util.Scanner;

public class BJ_2444_별찍기7 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}