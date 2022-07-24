/**
 * 이코테 4-3 게임 개발
 * @ prob : 
 * @ level : 
 */

import java.io.*;
import java.util.*;

public class 이코테_4_3_게임개발 {

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int[] cur = new int[3];
        st = new StringTokenizer(br.readLine());
        cur[0] = Integer.parseInt(st.nextToken());
        cur[1] = Integer.parseInt(st.nextToken());
        cur[2] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 위치 방문 체크
        int visitCount = 1;
        map[cur[0]][cur[1]] = 2;

        while (true) {
            boolean canGo = false;
            // 4방향 체크 및 이동
            for (int d = 1; d <= 4; d++) {
                int nd = turn(cur[2], d);
                int nr = cur[0] + dr[nd];
                int nc = cur[1] + dc[nd];
                // 가본 적 없는 육지이면 이동
                if (isInOfBound(nr, nc, N, M) && map[nr][nc] == 0) {
                    visitCount++;
                    map[nr][nc] = 2;
                    cur[0] = nr;
                    cur[1] = nc;
                    cur[2] = nd;
                    canGo = true;
                    break;
                }
            }
            // 4방향 모두 갈 수 없는 경우
            if (!canGo) {
                // 방향 + : 해당 방향으로 이동
                // 방향 - : 반대 방향으로 이동
                int nr = cur[0] - dr[cur[2]];
                int nc = cur[1] - dc[cur[2]];
                // 뒤가 바다라 갈 수 없는 경우 종료
                if (!isInOfBound(nr, nc, N, M) || map[nr][nc] == 1) {
                    break;
                }
                cur[0] = nr;
                cur[1] = nc;
            }
        }

        System.out.println(visitCount);

        br.close();
    }
    
    private static int turn(int d, int count) {
        for (int i = 0; i < count; i++) {
            d = d == 0 ? 3 : d - 1;
        }
        return d;
    }

    private static boolean isInOfBound(int r, int c, int n, int m) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
    
}

// 다른 풀이 1
// https://github.com/ndb796/python-for-coding-test/blob/master/4/4.java
