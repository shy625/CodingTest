/**
 * JO 1341 구구단2
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2076&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1341_구구단2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();

        if (S <= E) {
            for (int i = S; i <= E; i++) {
                int count = 1;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        System.out.printf("%d * %d =", i, count);
                        if (i * count < 10) {
                            System.out.printf("  %d   ", i * count);
                        } else {
                            System.out.printf(" %d   ", i * count);
                        }
                        count++;
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } else {
            for (int i = S; i >= E; i--) {
                int count = 1;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        System.out.printf("%d * %d =", i, count);
                        if (i * count < 10) {
                            System.out.printf("  %d   ", i * count);
                        } else {
                            System.out.printf(" %d   ", i * count);
                        }
                        count++;
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
