/**
 * JO 1307 문자사각형1
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2071&sca=20
 * @ level : S3
 */

import java.util.Scanner;

public class JO_1307_문자사각형1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[][] charSquare = new char[N][N];
        int num = 0;
        for (int j = N - 1; j >= 0; j--) {
            for (int i = N - 1; i >= 0; i--) {
                charSquare[i][j] = (char) ('A' + num);
                num = (num + 1) % 26;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(charSquare[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
