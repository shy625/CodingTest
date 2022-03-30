/**
 * BJ 2636 치즈
 * @ prob : https://www.acmicpc.net/problem/2636
 * @ level : G4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int R, C;
    static int[][] board;
    static int cheeseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for(int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                cheeseCount += board[r][c];
            }
        }

        int hour = 0;
        while(true) {
            checkAir(0, 0, true);
            hour++;
            int prevCount = checkOutline();
            cheeseCount -= prevCount;
            if(cheeseCount == 0) {
                System.out.println(hour);
                System.out.println(prevCount);
                break;
            }
            checkAir(0, 0, false);
        }

        br.close();
    }

    private static void checkAir(int r, int c, boolean isAir) {
        Queue<int[]> q = new LinkedList<>();
        int from, to;

        if(isAir) {
            from = 0;
            to = 9;
        } else {
            from = 9;
            to = 0;
        }

        q.offer(new int[]{r, c});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(isInOfBound(nr, nc) && board[nr][nc] == from) {
                    board[nr][nc] = to;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    private static int checkOutline() {
        int count = 0;
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(board[r][c] == 1) {
                    for(int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if(board[nr][nc] == 9) {
                            board[r][c] = 3;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(board[r][c] == 3) {
                    board[r][c] = 9;
                }
            }
        }
        return count;
    }
}
