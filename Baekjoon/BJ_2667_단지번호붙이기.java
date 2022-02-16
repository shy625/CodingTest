/**
 * BJ 2667 단지번호붙이기
 * @ prob : https://www.acmicpc.net/problem/2667
 * @ level : S1
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2667_단지번호붙이기 {

    static int N;
    static char[][] map;
    static int num, count;      // num : 단지 번호, count : 단지 내 집 개수
    static ArrayList<Integer> blocks;   // 단지의 아파트 수
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        num = 0;
        blocks = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '1') {
                    num++;
                    count = 0;
                    dfs(i, j);
                    // bfs(i, j);
                    blocks.add(count);
                }
            }
        }
        Collections.sort(blocks);

        System.out.println(num);
        for (Integer block : blocks) {
            System.out.println(block);
        }

        br.close();
    }

    private static void dfs(int r, int c) {
        map[r][c] = ' ';    // 방문 처리
        count++;    // 단지 내 집 수 +1
        for(int d = 0; d < 4; d++) {    // 4방에 대해 다음 위치 탐색
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBound(nr, nc) && map[nr][nc] == '1') {     // 갈 수 있으면 간다
                dfs(nr, nc);
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        map[r][c] = ' ';    // 방문 처리
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            // 실제 방문했을 때 방문 처리하면 큐에는 들어와 있지만 아직 방문하기 전인 경우, 다시 선택되어 큐에 중복되어 들어올 수 있다
            // map[pos[0]][pos[1]] = ' ';
            count++;    // 단지 내 집 수 +1
            for(int d = 0; d < 4; d++) {    // 4방에 대해 다음 위치 탐색
                int nr = pos[0] + dr[d];
                int nc = pos[1] + dc[d];
                if(isInOfBound(nr, nc) && map[nr][nc] == '1') {     // 갈 수 있으면 간다
                    q.offer(new int[]{nr, nc});
                    // 방문 처리 -> 여기서 해야 이미 선택되어 큐에 들어가 있는 위치가 다시 선택되지 않는다
                    map[nr][nc] = ' ';
                }
            }
        }
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}