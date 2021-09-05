/**
 * @ BJ 2609 최대공약수와 최소공배수
 * @ prob : https://www.acmicpc.net/problem/2609
 */

import java.util.Scanner;

public class BJ_2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt(), b = sc.nextInt();
        int maxDiv = 0, minMul = 0;

        for(int i = 1; i <= Math.min(a, b); i++) {
            if(a % i == 0) {
                if(b % i == 0) {
                    maxDiv = i;
                }
            }
        }
        minMul = a * b / maxDiv;

        System.out.println(maxDiv);
        System.out.println(minMul);

        sc.close();
    }
}

// 다른 풀이 1
// 유클리드 호제법 이용
// https://ko.wikipedia.org/wiki/유클리드_호제법

// int maxDiv = 0, minMul = a * b;
// while(b != 0) {
//     if(b > a) {
//         int tmp = a;
//         a = b;
//         b = tmp;
//     }
//     int r = a % b;
//     a = b;
//     b = r;
// }
// maxDiv = a;
// minMul /= maxDiv;
