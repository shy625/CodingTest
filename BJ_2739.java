/**
 * @ BJ 2739 구구단
 * @ prob : https://www.acmicpc.net/problem/2739
 */

import java.util.Scanner;

public class BJ_2739 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
}