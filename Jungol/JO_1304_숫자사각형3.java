/**
 * JO 1304 숫자사각형3
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2070&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1304_숫자사각형3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(i + N * j + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
