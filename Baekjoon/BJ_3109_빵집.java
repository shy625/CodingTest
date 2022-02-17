/**
 * BJ 3109 빵집
 * @ prob : https://www.acmicpc.net/problem/3109
 * @ level : G2
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3109_빵집 {

    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 0, 1};   // 오위, 오, 오아래
    static int[] dc = {1, 1, 1};    // 오위, 오, 오아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for(int i = 0; i < R; i++) {    // 첫번쨰 열의 모든 출발점에 대해 연결 가능한지 체크
            if(dfs(i, 0)) {     // (i, 0)에서 DFS 출발
                count++;
            }
        }

        System.out.println(count);

        br.readLine();
    }

    private static boolean dfs(int r, int c) {
        if(c == C-1) {      // 마지막 열에 도착 -> 연결 가능
            return true;
        }
        map[r][c] = 'x';    // 방문 처리
        for(int d = 0; d < 3; d++) {    // 오위, 오, 오아래 순으로 확인
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBound(nr, nc) && map[nr][nc] == '.') {     // 갈 수 있는지 체크
                if(dfs(nr, nc)) {   // 간 길로 성공하면 true 반환, 간 길에서 실패하면 다음 방향으로 진행
                    return true;
                }
            }
        }
        return false;   // 3방향 다 실패하면 false
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}

// 추가 반례
// https://www.acmicpc.net/board/view/61054