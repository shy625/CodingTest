/**
 * @ SWEA 1954 달팽이 숫자
 * @ prob : https://bit.ly/3tGifjG
 * @ level : D2
 */

import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int[][] snail = new int[n][n];

            int r = 0, c = -1;
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            int count = 0;
            int num = 1;

            for(int i = 0; i < n * n; i++) {
                int nr = r + dr[count % 4];
                int nc = c + dc[count % 4];

                if((nr < 0) || (n <= nr) || (nc < 0) || (n <= nc)) {
                    count++;
                    i--;
                    continue;
                }
                if(snail[nr][nc] > 0) {
                    count++;
                    i--;
                    continue;
                }

                r = nr;
                c = nc;
                snail[r][c] = num++;
            }

            System.out.println("#" + t);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}