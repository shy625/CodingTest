/**
 * @ BJ 2443 별 찍기 - 6
 * @ prob : https://www.acmicpc.net/problem/2443
 */

import java.util.Scanner;

public class BJ_2443_별찍기6 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

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