/**
 * SWEA 1226 미로1
 * @ prob : https://bit.ly/3rFJaKL
 * @ level : D4
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1226_미로1 {

    static char[][] maze = new char[16][16];
    static int solve;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            br.readLine();
            for(int i = 0; i < 16; i++) {
                maze[i] = br.readLine().toCharArray();
            }

            solve = 0;
            // bfs();
            dfs(1, 1);

            System.out.println("#" + t + " " + solve);
        }

        br.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 1});  // 시작 지점 큐에 넣기
        while(!q.isEmpty()) {   // 큐가 빌 때까지 반복
            int[] cur = q.poll();   // 큐에서 빼기
            maze[cur[0]][cur[1]] = '1';     // 방문 처리
            for(int i = 0; i < 4; i++) {    // 현 위치 기준 4방에 대해 체크
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(maze[nr][nc] == '0') {   // 길이면 큐에 넣음
                    q.offer(new int[]{nr, nc});
                } else if(maze[nr][nc] == '3') {    // 도착 지점이면 바로 종료
                    solve = 1;
                    return;
                }
            }
        }
    }

    static void dfs(int r, int c) {
        if(maze[r][c] == '3') {     // 도착 지점이면 종료
            solve = 1;
            return;
        }
        maze[r][c] = '1';   // 현재 위치 방문 처리
        for(int i = 0; i < 4; i++) {    // 현 위치 기준 4방에 대해 체크
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(maze[nr][nc] != '1') {   // 벽이 아니면 재귀 호출
                dfs(nr, nc);
            }
        }
    }
}

// 풀이 1
// BFS 이용

// 풀이 2
// DFS 이용