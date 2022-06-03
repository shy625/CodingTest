/**
 * JO 1856 숫자사각형2
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1129&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1856_숫자사각형2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int num = 1;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < M; j++) {
                    System.out.print(num++ + " ");
                }
            } else {
                num += M;
                for (int j = 0; j < M; j++) {
                    System.out.print(--num + " ");
                }
                num += M;
            }
            System.out.println();
        }

        sc.close();
    }
}
