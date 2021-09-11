/**
 * @ BJ 10991 별 찍기 - 16
 * @ prob : https://www.acmicpc.net/problem/10991
 */

import java.util.Scanner;

public class BJ_10991_별찍기16 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        
        String s = "";
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n-i; j++) {
                System.out.print(" ");
            }
            System.out.println(s += "* ");
        }
    }
}