/**
 * JO 1338 문자삼각형1
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2074&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1338_문자삼각형1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[][] charTriangle = new char[N][N];
        int num = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                charTriangle[i][j] = ' ';
            }
        }

        for (int i = N - 1; i <= 2 * N - 2; i++) {
            for (int j = N - 1; i - j < N; j--) {
                charTriangle[i - j][j] = (char) ('A' + num);
                num = (num + 1) % 26;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(charTriangle[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
