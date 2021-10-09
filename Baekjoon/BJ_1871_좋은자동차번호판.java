/**
 * @ BJ 1871 좋은 자동차 번호판
 * @ prob : https://www.acmicpc.net/problem/1871
 */

import java.util.Scanner;

public class BJ_1871_좋은자동차번호판 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String[] parts = sc.next().split("-");
            int firstValue = 0;
            int digit = 1;
            for(int j = parts[0].length() - 1; j >= 0; j--) {
                firstValue += (parts[0].charAt(j) - 'A') * digit;
                digit *= 26;
            }
            int valueGap = Math.abs(firstValue - Integer.valueOf(parts[1]));
            System.out.println(valueGap <= 100 ? "nice" : "not nice");
        }

        sc.close();
    }
}

// 다른 풀이 1
// 차량 번호판의 문자 부분의 다른 계산법

// int firstValue = 0;
// for(int i = 0; i < parts[0].length(); i++) {
//     firstValue = firstValue * 26 + (parts[0].charAt(i) - 'A');
// }