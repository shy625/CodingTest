/**
 * BJ 2178 미로 탐색
 * @ prob : https://www.acmicpc.net/problem/2178
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class BJ_2178_미로탐색 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int r = 0; r < N; r++) {
            char[] row = br.readLine().toCharArray();
            map[r] = row;
        }

        System.out.println(bfs(0, 0));

        br.close();
    }

    private static int bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];

        isVisited[sr][sc] = true;
        q.offer(new int[] {sr, sc, 1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1) {
                return cur[2];
            }
            for(int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(isInOfBound(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == '1') {
                    isVisited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, cur[2]+1});
                }
            }
        }
        return -1;
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}

// 풀이 1
// 정해진 출발점에서 정해진 도착점까지 가는 최소 거리 구하기 -> BFS 사용