/**
 * BJ 25191 치킨댄스를 추는 곰곰이를 본 임스
 * @ prob : https://www.acmicpc.net/problem/25191
 * @ level : B4
 * 제1회 곰곰컴 A번
 */

import java.util.Scanner;

public class BJ_25191_치킨댄스를추는곰곰이를본임스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int maxBev = A / 2 + B;

        System.out.println(N >= maxBev ? maxBev : N);

        sc.close();
    }
}

// 풀이 1
// 치킨 1마리당 콜라 2개 또는 맥주 1개
// 콜라 개수 / 2 + 맥주 개수 = 음료와 함께 최대로 먹을 수 있는 치킨 개수
// 음료와 함께 최대로 먹을 수 있는 치킨 개수와 치킨집에 있는 치킨 개수 중 최솟값 출력