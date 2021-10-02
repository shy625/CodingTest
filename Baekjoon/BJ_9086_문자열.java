/**
 * @ BJ 9086 문자열
 * @ prob : https://www.acmicpc.net/problem/9086
 */

import java.util.Scanner;

public class BJ_9086_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String str = sc.next();
            System.out.println("" + str.charAt(0) + str.charAt(str.length()-1));
        }

        sc.close();
    }
}