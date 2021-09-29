/**
 * @ BJ 10953 A+B - 6
 * @ prob : https://www.acmicpc.net/problem/10953
 */

import java.util.Scanner;

public class BJ_10953_A더하기B6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.valueOf(sc.nextLine());
        for(int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(",");
            System.out.println(Integer.valueOf(input[0]) + Integer.valueOf(input[1]));
        }

        sc.close();
    }
}

// 다른 풀이 1
// char 타입으로 연산

// String input = sc.nextLine();
// System.out.println(input.charAt(0)-'0' + input.charAt(2)-'0');