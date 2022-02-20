/**
 * BJ 1987 알파벳
 * @ prob : https://www.acmicpc.net/problem/1987
 * @ level : G4
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1987_알파벳 {

    static int R, C;
    static char[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int maxCount;
    static boolean[][] isVisited;   // 풀이 1, 2, 3
    static List<Character> passedList;      // 풀이 1, 2
    static int[][] visitied;    // 풀이 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        board = new char[R][C];
        for(int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        isVisited = new boolean[R][C];      // 풀이 1, 2, 3
        isVisited[0][0] = true;     // 풀이 1, 2, 3
        passedList = new ArrayList<>();     // 풀이 1, 2
        passedList.add(board[0][0]);    // 풀이 1, 2
        visitied = new int[R][C];   // 풀이 4

        // traverse(0, 0, 1, isVisited, passedList);   // 풀이 1
        // traverse(0, 0, 1);      // 풀이 2
        // traverse(0, 0, 1, 1 << board[0][0] - 'A');    // 풀이 3
        traverse4(0, 0, 1, 1 << board[0][0] - 'A');    // 풀이 4

        System.out.println(maxCount);

        br.close();
    }

    // 풀이 1
    private static void traverse(int r, int c, int count, boolean[][] isVisited, List<Character> passedList) {
        for(int d = 0; d < 4; d++) {    // 4방 탐색
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBounded(nr, nc) && !isVisited[nr][nc] && !passedList.contains(board[nr][nc])) {    // 배열 범위, 방문 여부, 알파벳 중복 여부 체크
                isVisited[nr][nc] = true;
                passedList.add(board[nr][nc]);
                traverse(nr, nc, count + 1, isVisited, passedList);
                isVisited[nr][nc] = false;
                passedList.remove(passedList.size() - 1);
            }
        }
        maxCount = Math.max(maxCount, count);
    }

    // 풀이 2
    private static void traverse(int r, int c, int count) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBounded(nr, nc) && !isVisited[nr][nc] && !passedList.contains(board[nr][nc])) {
                isVisited[nr][nc] = true;
                passedList.add(board[nr][nc]);
                traverse(nr, nc, count + 1);
                isVisited[nr][nc] = false;
                passedList.remove(passedList.size() - 1);
            }
        }
        maxCount = Math.max(maxCount, count);
    }

    // 풀이 3
    private static void traverse(int r, int c, int count, int flag) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBounded(nr, nc) && !isVisited[nr][nc] && (flag & 1 << board[nr][nc] - 'A') == 0) {
                isVisited[nr][nc] = true;
                traverse(nr, nc, count + 1, flag | 1 << board[nr][nc] - 'A');
                isVisited[nr][nc] = false;
            }
        }
        maxCount = Math.max(maxCount, count);
    }

    // 풀이 4
    private static void traverse4(int r, int c, int count, int flag) {
        if(visitied[r][c] == flag) {
            return;
        }
        visitied[r][c] = flag;
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBounded(nr, nc) && (flag & 1 << board[nr][nc] - 'A') == 0) {
                traverse4(nr, nc, count + 1, flag | 1 << board[nr][nc] - 'A');
            }
        }
        maxCount = Math.max(maxCount, count);
    }

    private static boolean isInOfBounded(int nr, int nc) {
        return 0 <= nr && nr < R && 0 <= nc && nc < C;
    }
}

// 풀이 1
// isVisited, passedList를 traverse() 메소드의 파라미터로 전달하여 접근
// 3232ms

// 풀이 2
// isVisited, passedList를 클래스변수로 선언하여 traverse() 메소드에서 접근
// 3080ms

// 풀이 3
// passedList 대신 비트마스킹을 이용해 알파벳 중복 체크
// 988ms

// 풀이 4
// passedList 대신 비트마스킹을 이용해 알파벳 중복 체크
// 현재까지 지나온 알파벳의 집합 정보인 flag를 방문체크 배열에 저장, 비교함으로써
// 지나온 경로는 다르더라도 현재 위치까지 동일한 집합의 알파벳을 지나왔으면 어차피 이후는 동일하기 때문에 더 이상 체크 X
// 현재 위치까지 다른 알파벳들을 거쳐온 경우만 계속 체크
// 168ms
// 참고
// https://www.acmicpc.net/source/39247975
// https://www.acmicpc.net/source/26506622