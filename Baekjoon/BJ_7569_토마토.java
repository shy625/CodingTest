/**
 * BJ 7569 토마토
 * @ prob : https://www.acmicpc.net/problem/7569
 * @ level : G5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {

    static int[] dz = { 0, 0, 0, 0, 1, -1 };    // 높이
    static int[] dy = { -1, 0, 1, 0, 0, 0 };    // 행
    static int[] dx = { 0, 1, 0, -1, 0, 0 };    // 열
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 - 열
        N = Integer.parseInt(st.nextToken()); // 세로 - 행
        H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] tomatoes = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();    // 익은 토마토 위치 저장
        int unripes = 0;    // 덜 익은 토마토 개수

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {   // 익은 토마토
                        q.offer(new int[] { i, j, k });
                    }
                    if (tomatoes[i][j][k] == 0) {   // 덜 익은 토마토
                        unripes++;
                    }
                }
            }
        }

        int day = 0;    // 날짜
        int prev = q.size();    // 이전 날짜에 익은 토마토 개수
        while (unripes > 0) {
            int turn = 0;   // 이번 날짜에 익은 토마토 개수
            for (int i = 0; i < prev; i++) {    // 이전 날짜에 익은 토마토에 대해서만 수행
                int[] cur = q.poll();
                for (int d = 0; d < 6; d++) {   // 6방 탐색
                    int nz = cur[0] + dz[d];
                    int ny = cur[1] + dy[d];
                    int nx = cur[2] + dx[d];
                    if (isInOfBound(nx, ny, nz) && tomatoes[nz][ny][nx] == 0) {     // 유효성 체크
                        tomatoes[nz][ny][nx] = 1;
                        turn++;
                        q.offer(new int[] { nz, ny, nx });
                    }
                }
            }
            if (turn == 0) {    // 이번 날짜에 익은 토마토가 없으면 더 이상 토마토가 익을 수 없음
                day = -1;
                break;
            }
            unripes -= turn;
            prev = turn;
            day++;
        }

        System.out.println(day);

        br.close();
    }

    private static boolean isInOfBound(int x, int y, int z) {
        return 0 <= x && x < M && 0 <= y && y < N && 0 <= z && z < H;
    }
}

// 풀이 1 - 시간초과
// 토마토 상자인 3차원 배열에 대해 모든 원소를 방문하며 익은 토마토가 나왔을 때 주변의 안익은 토마토에 대해 처리
// 하나의 3차원 배열에서 바로 토마토 값을 변경하며 모든 원소를 돌게 되면
// 이번에 익은 토마토는 다음 날에 방문하여 처리해야 되는데 이어서 바로 방문하게 될 수 있음
// 따라서 3차원 임시 배열을 생성하여 모든 원소 방문 전 상태를 저장
// 익은 토마토 찾기는 원래 배열에서 하고, 안익은 토마토의 숙성 처리는 임시 배열에서 수행
// 해당 일의 모든 처리가 끝나면 임시 배열을 원래 배열에 대입
// https://www.acmicpc.net/source/43003577

// 풀이 2 - 시간초과
// 풀이 1에 isVisited 배열 추가
// 익은 토마토에 대해 방문 처리하여 한번 확인한 익은 토마토는 다시 확인하지 않도록 처리
// https://www.acmicpc.net/source/43003734

// 풀이 3
// 매번 모든 원소를 방문하게 되므로 시간초과 발생
// 익은 토마토의 위치를 저장하는 Queue를 생성하여 모든 원소가 아닌 익은 토마토의 위치만 방문
// 해당 날짜에 익은 토마토 개수를 저장하고 다음 날짜에 저장한 토마토 개수만큼만 Queue에서 원소를 빼내어 처리
// 이번에 익은 토마토를 바로 방문할 일이 없으므로 isVisited 배열도 필요 X

// 다른 풀이 1
// 토마토의 위치를 비트마스킹을 이용하여 Queue에 저장
// https://www.acmicpc.net/source/28012163