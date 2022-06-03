/**
 * JO 1303 숫자사각형1
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2069&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1303_숫자사각형1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
