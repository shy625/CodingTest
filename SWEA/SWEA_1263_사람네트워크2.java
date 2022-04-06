/**
 * SWEA 1263 사람 네트워크2
 * @ prob : https://bit.ly/3Hvey4b
 * @ level : D6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {

    static final int INF = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[][] network = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    network[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 연결되지 않은 부분 INF로 초기화
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(network[i][j] == 0) {
                        network[i][j] = INF;
                    }
                }
            }

            // 플로이드 워셜
            for(int k = 0; k < N; k++) {
                for(int i = 0; i < N; i++) {
                    if(k == i) {
                        continue;
                    }
                    for(int j = 0; j < N; j++) {
                        // if(k != j && i != j) {
                        if(k != j && i < j) {   // 양방향이므로 대각선 위 또는 아래만 수행하는 것이 더 빠름
                            if(network[i][j] > network[i][k] + network[k][j]) {
                                network[i][j] = network[i][k] + network[k][j];
                                network[j][i] = network[i][j];  // 양방향 그래프이므로 network[i][j] == network[j][i]
                            }
                        }
                    }
                }
            }

            // 합 및 최솟값 계산
            int min = INF;
            for(int i = 0; i < N; i++) {
                int sum = 0;
                for(int j = 0; j < N; j++) {
                    if(network[i][j] != INF) {
                        sum += network[i][j];
                    }
                }
                min = Math.min(min, sum);
            }

            sb.append("#" + t + " " + min).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// 플로이드 워셜 사용 - 양방향 그래프이므로 대각선 위 또는 아래 중 한쪽만 수행하여 결과 대입
// 2307ms

// 다른 풀이 1
// 동일하게 플로이드 워셜 사용인데 시간 개선
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do
// 1418ms

// 다르 풀이 2
// 다익스트라 사용
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do

// 다른 풀이 3
// BFS 사용
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do