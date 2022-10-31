import java.io.*;
import java.util.*;

public class BJ_S1_11403_경로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        
        int[][] adjMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j] >= 2 ? 1 : adjMatrix[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(adjMatrix[i][j] + " ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// 가중치가 없는 방향 그래프 → 모든 정점 i, j에 대해 i → j로 가는 경로가 있는지 확인
// 모든 정점 쌍에 대해 구하기 → 플로이드 워셜 사용
// 원래는 모든 쌍에 대해 최소 경로를 구하는 알고리즘이지만 가중치가 없으므로 단순히 갈 수 있는지 없는지 여부 탐색
// adjMatrix[i][k]와 adjMatrix[k][j]가 동시에 가능한지 여부 확인
// 한쪽만 가능한 경우는 X

// 다른 풀이 1
// 동일하게 플로이드 워셜 사용
// 단, 인접행렬을 boolean 타입으로 생성
// https://www.acmicpc.net/source/44378921