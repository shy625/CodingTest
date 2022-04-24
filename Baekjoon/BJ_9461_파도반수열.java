/**
 * BJ 9461 파도반 수열
 * @ prob : https://www.acmicpc.net/problem/9461
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arrN = new int[T];    // 테스트케이스마다 주어진 값 배열
        int max = 0;
        for(int t = 0; t < T; t++) {
            arrN[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, arrN[t]);   // 주어진 값 중 최대값 저장
        }

        // DP
        long[] dp = new long[max+1];    // 주어진 값 중 최대값까지 DP 배열 계산
        dp[1] = dp[2] = dp[3] = 1L;
        for(int i = 4; i <= max; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int n : arrN) {
            sb.append(dp[n]).append(System.lineSeparator());
        }

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1 - 시간초과
// 재귀 사용
// https://www.acmicpc.net/source/42493706

// private static int p(int n) {
//     if(n == 1 || n == 2 || n == 3) {
//         return 1;
//     }
//     return p(n-2) + p(n-3);
// }

// 풀이 2
// DP 사용
// P(n)의 값 저장
// dp[i] = dp[i-2] + dp[i-3];
// 주어진 N 값이 크면 int 범위를 넘어감 -> DP 배열에 long 사용