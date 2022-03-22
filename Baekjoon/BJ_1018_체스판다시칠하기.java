/**
 * BJ 1018 체스판 다시 칠하기
 * @ prob : https://www.acmicpc.net/problem/1018
 * @ level : S5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for(int r = 0; r < N; r++) {
            board[r] = br.readLine().toCharArray();
        }

        // 올바른 체스판 만들기 편하게 반복되는 줄 미리 생성
        char[] wCharArr = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
        char[] bCharArr = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};

        // 올바른 체스판을 만들어서 같은지 다른지 비교
        char[][] wChess = new char[8][8];
        char[][] bChess = new char[8][8];
        for(int r = 0; r < 8; r++) {
            if(r % 2 == 0) {
                wChess[r] = wCharArr;
                bChess[r] = bCharArr;
            } else {
                wChess[r] = bCharArr;
                bChess[r] = wCharArr;
            }
        }

        int min = Integer.MAX_VALUE;
        char[][] chess = new char[8][8];
        for(int r = 0; r < N-7; r++) {
            for(int c = 0; c < M-7; c++) {
                for(int i = 0; i < 8; i++) {
                    chess[i] = Arrays.copyOfRange(board[r+i], c, c+8);
                }
                min = Math.min(min, countDiff(chess, wChess));  // 흰색으로 시작하는 체스판과 비교
                min = Math.min(min, countDiff(chess, bChess));  // 검은색으로 시작하는 체스판과 비교
            }
        }
        System.out.println(min);

        br.close();
    }

    private static int countDiff(char[][] original, char[][] target) {
        int count = 0;
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                if(original[r][c] != target[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}

// 풀이 1
// 올바른 2종류의 체스판을 미리 만들고,
// 보드의 (0, 0) ~ (N-7, M-7)을 시작점으로 하는 8x8 배열에 대해 올바른 체스판과 비교하여 다른 개수 찾아 최솟값 출력

// 다른 풀이 1
// https://bambbang00.tistory.com/43

// 다른 풀이 2
// https://www.acmicpc.net/source/12595238