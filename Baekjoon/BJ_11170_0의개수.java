/**
 * @ BJ 11170 0의 개수
 * @ prob : https://www.acmicpc.net/problem/11170
 */

import java.util.Scanner;

public class BJ_11170_0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int count = 0;
            for(int j = n; j <= m; j++) {
                int num = j;
                if(num == 0) {
                    count++;
                }
                while(num > 0) {
                    if(num % 10 == 0) {
                        count++;
                    }
                    num /= 10;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}

// 다른 풀이 1
// String으로 받아 각 자리가 '0'인지 확인

// int n = sc.nextInt(), m = sc.nextInt();
// int count = 0;
// for(int j = n; j <= m; j++) {
//     String num = j + "";
//     for(int k = 0; k < num.length(); k++) {
//         if(num.charAt(k) == '0') {
//             count++;
//         }
//     }
// }
// System.out.println(count);