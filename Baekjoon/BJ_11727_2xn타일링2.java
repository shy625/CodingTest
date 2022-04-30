/**
 * BJ 11727 2xn 타일링 2
 * @ prob : https://www.acmicpc.net/problem/11727
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727_2xn타일링2 {

    static final int MOD_FACTOR = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int result = 0;

        if(N == 1) {
            result = 1;
        } else {
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= N; i++) {
                if(i % 2 == 0) {
                    dp[i] = ((int)Math.pow(dp[i/2], 2) + 2 * (int)Math.pow(dp[i/2-1], 2)) % MOD_FACTOR;
                } else {
                    dp[i] = ((int)Math.pow(dp[i/2], 2) + 2 * 2 * dp[i/2] * dp[i/2-1]) % MOD_FACTOR;
                }
            }
            result = dp[N];
        }

        System.out.println(result);

        br.close();
    }
}

// 풀이 1
// DP 사용
// 주어진 직사각형을 반으로 나누어 경우의 수를 생각
// 반으로 나누었을 때 가운데를 연결하지 않는 경우 (가운데에 2칸짜리를 놓지 않는 경우) + 반으로 나누었을 때 가운데를 연결하는 경우 (가운데에 2칸짜리를 놓는 경우)
// dp[i] : 2xi 일 때 채우는 경우의 수 저장
// 1. dp[i] = dp[i/2]^2 + 2 * dp[i/2-1]^2 - i가 짝수인 경우
// 2. dp[i] = dp[i/2]^2 + 2 * 2 * dp[i/2] * dp[i/2-1] - i가 홀수인 경우

// 다른 풀이 1
// https://www.acmicpc.net/source/15543037
// https://jaemin8852.tistory.com/158
// https://lecor.tistory.com/58

// 다른 풀이 2
// https://www.acmicpc.net/source/25211291
