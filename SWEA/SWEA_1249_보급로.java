/**
 * SWEA 1249 보급로
 * @ prob : https://bit.ly/3KlXYFi
 * @ level : D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SWEA_1249_보급로 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static int min;
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int r = 0; r < N; r++) {
                String str = br.readLine();
                for(int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c) - '0';
                }
            }
            sb.append("#" + t + " " + dijkstra(0, 0)).append(System.lineSeparator());
            // min = Integer.MAX_VALUE;
            // isVisited = new boolean[N][N];
            // dfs(0, 0, 0);
            // sb.append("#" + t + " " + min).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static int dijkstra(int sr, int sc) {
        boolean[][] isVisited = new boolean[N][N];
        int[][] minTime = new int[N][N];

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                minTime[r][c] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];   // 오름차순 -> 최소힙
            }
        });

        minTime[sr][sc] = 0;
        pq.offer(new int[] {sr, sc, minTime[sr][sc]});

        // while(!pq.isEmpty()) {
        while(true) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int minCost = cur[2];
            if(isVisited[r][c]) {
                continue;
            }
            isVisited[r][c] = true;
            if(r == N-1 && c == N-1) {
                return minCost;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(isInOfBound(nr, nc)
                //  && !isVisited[nr][nc]      // 할 필요 x
                 && minTime[nr][nc] > minCost + map[nr][nc]) {
                    minTime[nr][nc] = minCost + map[nr][nc];
                    pq.offer(new int[] {nr, nc, minTime[nr][nc]});
                }
            }
        }
    }

    private static void dfs(int r, int c, int sum) {
        if(sum > min) {
            return;
        }
        if(r == N-1 && c == N-1) {
            min = Math.min(min, sum);
            return;
        }
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBound(nr, nc) && !isVisited[nr][nc]) {
                isVisited[nr][nc] = true;
                dfs(nr, nc, sum + map[nr][nc]);
                isVisited[nr][nc] = false;
            }
        }
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}

// 풀이 1
// DFS

// 풀이 2
// Dijkstra 이용

// 풀이 3
// BFS + DP 이용

// 풀이 4
// BFS + PQ => 사실상 Dijkstra의 원리와 동일