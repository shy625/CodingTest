/**
 * BJ 1389 케빈 베이컨의 6단계 법칙
 * @ prob : https://www.acmicpc.net/problem/1389
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] relation = new int[N+1][N+1];
        for(int i = 0; i < N+1; i++) {
            // 모든 사람을 다 거쳐서 연결되는 경우가 최악 -> 100
            // 따라서 101 이상의 임의값으로 초기화
            Arrays.fill(relation[i], 1000);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relation[from][to] = 1;
            relation[to][from] = 1;
        }

        // 플로이드 워셜
        for(int k = 1; k <= N; k++) {   // 경유
            for(int i = 1; i <= N; i++) {   // 출발
                if(k == i) {
                    continue;
                }
                for(int j = 1; j <= N; j++) {   // 도착
                    if(k != j && i != j) {
                        if(relation[i][j] > relation[i][k] + relation[k][j]) {
                            relation[i][j] = relation[i][k] + relation[k][j];
                        }
                    }
                }
            }
        }

        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                if(i != j) {
                    sum += relation[i][j];
                }
            }
            if(min > sum) {
                min = sum;
                result = i;
            }
        }

        System.out.println(result);

        br.close();
    }
}

// 풀이 1
// 모든 쌍의 최소 경로 값 구하기 -> 플로이드 워셜 사용

// 다른 풀이 1
// 각 사람에 대해 BFS 사용하여 다른 사람으로의 거리 계산
// https://www.acmicpc.net/source/41099076
// https://www.acmicpc.net/source/18770554