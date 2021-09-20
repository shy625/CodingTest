/**
 * @ BJ 3460 이진수
 * @ prob : https://www.acmicpc.net/problem/3460
 */

import java.util.Scanner;

public class BJ_3460_이진수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int num = sc.nextInt();
            String binStr = Integer.toBinaryString(num);
            StringBuilder sb = new StringBuilder();
            for(int j = binStr.length()-1; j >= 0; j--) {
                if(binStr.charAt(j) == '1') {
                    sb.append(Math.abs(binStr.length()-1-j) + " ");
                }
            }
            System.out.println(sb.toString());
        }

        sc.close();
    }
}

// 다른 풀이 1
// 비트 연산자 이용 == 2의 % 연산 이용

// int num = sc.nextInt();
// int cur = 0;
// while(num > 0) {
//     if((num & 1) == 1) {    // (num % 2) == 1
//         System.out.print(cur + " ");
//     }
//     cur++;
//     num = num >> 1; // num /= 2
// }
// System.out.println();