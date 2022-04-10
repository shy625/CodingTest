/**
 * SWEA 5643 키 순서
 * @ prob : https://bit.ly/3LNXs3g
 * @ level : D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

    static int N, M;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adjMatrix = new int[N+1][N+1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjMatrix[a][b] = 1;
            }

            int count = 0;
            for(int i = 1; i <= N; i++) {
                int smaller = reverseBfs(i);    // 자신보다 작은 사람의 수
                int taller = naturalBfs(i);     // 자신보다 큰 사람의 수
                if(smaller + taller == N-1) {   // 자신의 키가 몇 번쨰인지 알 수 있는 경우
                    count++;
                }
            }
            sb.append("#" + t + " " + count).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    // 자신보다 키가 큰 방향으로 그래프 탐색
    private static int naturalBfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];
        int count = 0;

        q.offer(vertex);
        isVisited[vertex] = true;
        while(!q.isEmpty()) {
            int v = q.poll();
            count++;
            for(int i = 1; i <= N; i++) {
                if(adjMatrix[v][i] == 1 && !isVisited[i]) {     // 자신으로부터 나가는 간선 체크
                    isVisited[i] = true;
                    q.offer(i);
                }
            }
        }
        return count - 1;   // 자신 제외
    }

    // 자신보다 키가 작은 방향으로 그래프 탐색
    private static int reverseBfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];
        int count = 0;

        q.offer(vertex);
        isVisited[vertex] = true;
        while(!q.isEmpty()) {
            int v = q.poll();
            count++;
            for(int i = 1; i <= N; i++) {
                if(adjMatrix[i][v] == 1 && !isVisited[i]) {     // 자신으로 들어오는 간선 체크
                    isVisited[i] = true;
                    q.offer(i);
                }
            }
        }
        return count - 1;   // 자신 제외
    }
}

// 풀이 1
// 그래프 탐색 이용
// 주어진 관계를 이용해 인접배열로 그래프 표현
// 자신보다 키가 작은 사람 수 + 자신보다 키가 큰 사람 수 = 전체에서 자신을 제외한 수
// 와 같다면 자신이 몇 번째인지 특정할 수 있음
// 큰 사람 - 정방향, 나가는 간선을 따라 탐색
// 작은 사람 - 역방향, 들어오는 간선을 따라 탐색 <- 역방향 탐색을 편리하게 하기 위해 인접배열 선택