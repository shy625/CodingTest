/**
 * @ BJ 4963 섬의 개수
 * @ prob : https://www.acmicpc.net/problem/4963
 * @ level : S2
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_4963_섬의개수 {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int W, H;
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] inputs = br.readLine().split(" ");
            W = Integer.parseInt(inputs[0]);
            H = Integer.parseInt(inputs[1]);
            if(W == 0 && H == 0) {
                break;
            }
            map = new String[H][W];
            for(int i = 0; i < H; i++) {
                map[i] = br.readLine().split(" ");
            }

            int count = 0;
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(map[i][j].equals("1")) {
                        count++;
                        dfs(i, j);
                        // bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }

        br.close();
    }

    private static void dfs(int r, int c) {
        map[r][c] = "";     // 방문 처리
        for(int i = 0; i < 8; i++) {    // 8방에 대해 다음 위치 탐색
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(isInOfBound(nr, nc) && map[nr][nc].equals("1")) {    // 갈 수 있으면 간다
                dfs(nr, nc);
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            map[pos[0]][pos[1]] = "";   // 방문 처리
            for(int i = 0; i < 8; i++) {    // 8방에 대해 다음 위치 탐색
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                if(isInOfBound(nr, nc) && map[nr][nc].equals("1")) {    // 갈 수 있으면 간다
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < H && 0 <= c && c < W;
    }

}

// dfs 168ms
// bfs 메모리 초과