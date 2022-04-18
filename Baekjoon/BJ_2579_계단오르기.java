/**
 * BJ 2579 계단 오르기
 * @ prob : https://www.acmicpc.net/problem/2579
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];    // i번째 계단을 밟을 때 점수의 최댓값 저장
        
        dp[0] = 0;  // 시작점
        dp[1] = stairs[1];   // 첫번째 계단
        if(N > 1) {     // 계단 개수가 1보다 클 때 진행, 그렇지 않으면 dp[2] 접근 시 ArrayIndexOutOfBoundsException 발생
            dp[2] = dp[1] + stairs[2];   // 두번째 계단
            for(int i = 3; i < N+1; i++) {
                // 1. 전전 계단을 밟고 현재 계단을 밟는 경우
                // 2. 전전전 계단과 전 계단을 밟고 현재 계단을 밟는 경우 (그냥 전 계단만 고려하면 연속해서 3계단을 밟을 수도 있음)
                dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
            }
        }

        System.out.println(dp[N]);

        br.close();
    }
}

// 풀이 1
// DP 사용
// i번째 계단을 밟을 때 점수의 최댓값 저장
// dp[i] = Math.max(dp[i-2], dp[i-3] + steps[i-1]) + steps[i]

// 다른 풀이 1
// 1칸 전에서 올 때와 2칸 전에서 올 때를 구분하여 DP 배열에 저장
// https://www.acmicpc.net/source/20183174