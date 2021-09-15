/**
 * @ BJ 2440 별 찍기 - 3
 * @ prob : https://www.acmicpc.net/problem/2440
 */

import java.util.Scanner;

public class BJ_2440_별찍기3 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}