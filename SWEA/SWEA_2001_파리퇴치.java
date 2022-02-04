/**
 * SWEA 2001 파리 퇴치
 * @ prob : https://bit.ly/3Hvey4b
 * @ level : D2
 */

import java.util.Scanner;

public class SWEA_2001_파리퇴치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] flies = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    flies[i][j] = sc.nextInt();
                }
            }

            int max = Integer.MIN_VALUE;
            // 주어진 영역의 (0, 0)부터 (N-M, N-M)까지만 반복
            for(int i = 0; i <= N-M; i++) {
                for(int j = 0; j <= N-M; j++) {
                    int sum = 0;
                    // (i, j)를 파리채의 좌상단 위치로 하여 파리채 영역 내의 파리 수 합 계산
                    for(int k = i; k < i+M; k++) {
                        for(int l = j; l < j+M; l++) {
                            sum += flies[k][l];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.printf("#%d %d\n", t, max);
        }

        sc.close();
    }
}