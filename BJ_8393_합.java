/**
 * @ BJ 8393 합
 * @ prob : https://www.acmicpc.net/problem/8393
 */

import java.util.Scanner;

public class BJ_8393_합 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}

// 다른 풀이 1
// 등차수열의 합 공식 사용

// sum = n * (n+1) / 2;
