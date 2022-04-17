/**
 * BJ 1780 종이의 합
 * @ prob : https://www.acmicpc.net/problem/1780
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780_종이의합 {

    static int[][] paper;
    static int[] counts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        counts = new int[3];
        cut(0, 0, N);
        
        System.out.println(counts[0]);
        System.out.println(counts[1]);
        System.out.println(counts[2]);

        br.close();
    }

    private static void cut(int sr, int sc, int n) {
        boolean isOne = true;
        int first = paper[sr][sc];
        for(int r = sr; r < sr + n; r++) {
            for(int c = sc; c < sc + n; c++) {
                if(first != paper[r][c]) {
                    isOne = false;
                    break;
                }
            }
        }

        if(isOne) {
            counts[first+1]++;
            return;
        }

        int nn = n / 3;
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                cut(sr + nn * r, sc + nn * c, nn);
            }
        }
    }
}

// 풀이 1
// 분할정복
// 주어진 영역에 대해 모든 값이 같으면 해당 값의 종이 개수 증가
// 모든 값이 같지 않으면 9영역으로 나누어 각 영역에 대해 재귀 함수 호출