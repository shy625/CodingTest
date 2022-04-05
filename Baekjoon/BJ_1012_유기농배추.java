/**
 * BJ 1012 유기농 배추
 * @ prob : https://www.acmicpc.net/problem/1012
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                map[r][c] = -1;
            }

            int group = 0;  // 인접한 배추의 그룹 수
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(map[r][c] == -1) {
                        bfs(r, c, ++group);
                    }
                }
            }
            sb.append(group).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    // BFS를 이용해 서로 인접한 그룹 탐색
    private static void bfs(int r, int c, int group) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = group;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(isInOfBound(nr, nc) && map[nr][nc] == -1) {
                    map[nr][nc] = group;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}

// 풀이 1
// BFS 사용 - Flood Fill

// 다른 풀이 1
// DFS & 비트마스킹 활용
// https://www.acmicpc.net/source/29959416