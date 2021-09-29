/**
 * @ BJ 2902 KMP는 왜 KMP일까?
 * @ prob : https://www.acmicpc.net/problem/2902
 */

import java.util.Scanner;

public class BJ_2902_KMP는왜KMP일까 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("-");
        String output = "";
        for(int i = 0; i < input.length; i++) {
            output += input[i].charAt(0);
        }
        System.out.println(output);

        sc.close();
    }
}

// 다른 풀이 1
// 대문자를 제외하고 나머지 모든 문자를 빈 문자열로 변경

// System.out.println(sc.nextLine().replaceAll("[^A-Z]", ""));
