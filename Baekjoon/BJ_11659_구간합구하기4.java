/**
 * BJ 11659 구간 합 구하기 4
 * @ prob : https://www.acmicpc.net/problem/11659
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cumSum = new int[N+1];    // 누적합 배열
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            cumSum[i] = cumSum[i-1] + Integer.parseInt(st.nextToken());     // 이전 누적합에 입력값 더해서 저장
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(cumSum[to] - cumSum[from-1]).append(System.lineSeparator());  // 누적합을 이용한 구간합 계산
        }

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// 누적합 사용