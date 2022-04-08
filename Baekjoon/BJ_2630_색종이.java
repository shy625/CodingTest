/**
 * BJ 2630 색종이
 * @ prob : https://www.acmicpc.net/problem/2630
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이 {

    static int[][] paper;
    static int[] count = new int[2];     // 0 : white, 1 : blue
    static int[] dr = {0, 1, 0, 1};     // 좌상, 우상, 좌하, 우하
    static int[] dc = {0, 0, 1, 1};     // 좌상, 우상, 좌하, 우하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        
        paper = new int[N][N];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);

        br.close();
    }

    private static void cut(int sr, int sc, int n) {
        boolean isOneColor = true;
        for(int r = sr; r < sr + n; r++) {
            for(int c = sc; c < sc + n; c++) {
                if(paper[sr][sc] != paper[r][c]) {  // 영역 내에 하나라도 다른 색이 있으면 종료
                    isOneColor = false;
                    break;
                }
            }
        }

        // 정사각형이 모든 영역이 같은 색인 경우, 해당 색 개수 증가
        if(isOneColor) {
            count[paper[sr][sc]]++;
            return;
        }

        // 4영역으로 잘라 확인
        for(int d = 0; d < 4; d++) {
            int nr = sr + dr[d] * n/2;
            int nc = sc + dc[d] * n/2;
            cut(nr, nc, n/2);
        }
    }
}

// 풀이 1
// 분할정복 + 재귀
// 현재 주어진 정사각형 영역이 모두 하나의 색으로 이루어져 있는지 확인하고
// 하나의 색이면 해당하는 색의 개수 증가
// 다른 색이 있으면 해당 영역을 4영역으로 나누어 동일한 함수 호출