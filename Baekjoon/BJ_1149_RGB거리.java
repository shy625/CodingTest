/**
 * BJ 1149 RGB 거리
 * @ prob : https://www.acmicpc.net/problem/1149
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        // DP 메모이제이션 배열
        int[][] minCosts = new int[N][3];
        minCosts[0][0] = rgb[0][0];
        minCosts[0][1] = rgb[0][1];
        minCosts[0][2] = rgb[0][2];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {    // i번째 집에 칠하는 색깔
                int prevMin = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++) {    // i-1번째 집에 칠한 색깔
                    if(j != k) {
                        prevMin = Math.min(prevMin, minCosts[i-1][k]);
                    }
                }
                minCosts[i][j] = prevMin + rgb[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            min = Math.min(min, minCosts[N-1][i]);
        }
        System.out.println(min);

        br.close();
    }
}

// 풀이 1
// i번째 집을 r, g, b로 칠했을 때 최솟값 = 1 ~ i-1까지 칠하는 최소값 + i번째 r, g, b로 칠하기
// 참고
// https://taxol1203.github.io/codingtest/bj-rgb%EA%B1%B0%EB%A6%AC/
// https://www.acmicpc.net/source/36689455
// https://www.acmicpc.net/source/41266785