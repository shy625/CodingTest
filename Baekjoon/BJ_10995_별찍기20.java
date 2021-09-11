/**
 * @ BJ 10995 별 찍기 - 20
 * @ prob : https://www.acmicpc.net/problem/10995
 */

import java.util.Scanner;

public class BJ_10995_별찍기20 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        String s = "*";
        for(int i = 1; i < n; i++) {
            s += " *";
        }
        for(int i = 1; i <= n; i++) {
            if(i%2 == 0) {
                System.out.println(" " + s);
            } else {
                System.out.println(s);
            }
        }
    }
}