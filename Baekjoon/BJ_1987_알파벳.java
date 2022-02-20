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
    static boolean[][] isVisited;
    static List<Character> passedList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        R = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        board = new char[R][C];
        for(int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        isVisited = new boolean[R][C];
        isVisited[0][0] = true;
        passedList = new ArrayList<>();
        passedList.add(board[0][0]);

        // traverse(0, 0, 1, isVisited, passedList);
        traverse(0, 0, 1);


        System.out.println(maxCount);

        br.close();
    }

    // private static void traverse(int r, int c, int count, boolean[][] isVisited, List<Character> passedList) {
    private static void traverse(int r, int c, int count) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isInOfBounded(nr, nc) && !isVisited[nr][nc] && !passedList.contains(board[nr][nc])) {
                isVisited[nr][nc] = true;
                passedList.add(board[nr][nc]);
                // traverse(nr, nc, count + 1, isVisited, passedList);
                traverse(nr, nc, count + 1);
                isVisited[nr][nc] = false;
                passedList.remove(passedList.size() - 1);
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
// isVisitedm passedList를 클래스변수로 선언하여 traverse() 메소드에서 접근
// 3080ms

// 다른 풀이 1
// 비트마스킹 활용
// https://www.acmicpc.net/source/39247975
// 104ms