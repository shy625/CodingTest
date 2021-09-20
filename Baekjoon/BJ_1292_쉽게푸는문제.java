/**
 * @ BJ 1292 쉽게 푸는 문제
 * @ prob : https://www.acmicpc.net/problem/1292
 */

import java.util.Scanner;

public class BJ_1292_쉽게푸는문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        int[] arr = initArr(1000);
        int sum = 0;

        for(int i = a-1; i < b; i++) {
            sum += arr[i];
        }

        System.out.println(sum);

        sc.close();
    }

    static int[] initArr(int length) {
        int[] arr = new int[length];
        int cur = 1, count = 0;
        for(int i = 0; i < length; i++) {
            arr[i] = cur;
            count++;
            if(cur == count) {
                cur++;
                count = 0;
            }
        }
        return arr;
    }
}

// 다른 풀이 1
// 길이 1000짜리 전체 배열(수열)을 만들 필요없이 b까지만 배열 생성

// int[] arr = initArr(b);

// 다른 풀이 2-1
// 배열 생성하지 않고 바로 해당 수열의 합 계산 -> b까지의 부분합 - a-1까지의 부분합

// int sumA = 0, sumB = 0;
// int cur = 1, count = 0;
// for(int i = 1; i <= b; i++) {
//     sumB += cur;
//     count++;
//     if(cur == count) {
//         cur++;
//         count = 0;
//     }
//     if(i == a-1) {
//         sumA = sumB;
//     }
// }
// System.out.println(sumB-sumA);

// 다른 풀이 2-2
// 배열 생성하지 않고 바로 해당 수열의 합 계산 -> a부터 b일때만 합 계산

// int sum = 0;
// int cur = 1, count = 0;
// for(int i = 1; i <= b; i++) {
//     if(i >= a) {
//         sum += cur;
//     }
//     count++;
//     if(cur == count) {
//         cur++;
//         count = 0;
//     }
// }
// System.out.println(sum);

// 다른 풀이 3
// 수열의 규칙을 찾아 공식을 만들어 해결

// https://www.acmicpc.net/source/32812030
// https://www.acmicpc.net/source/29291169