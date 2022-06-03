/**
 * JO 1291 구구단
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=574&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1291_구구단 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int S = sc.nextInt();
            int E = sc.nextInt();
    
            if (!(2 <= S && S <= 9 && 2 <= E && E <= 9)) {
                System.out.println("INPUT ERROR!");
            } else {
                if (S <= E) {
                    for (int i = 1; i <= 9; i++) {
                        for (int j = S; j <= E; j++) {
                            System.out.printf("%d * %d =", j, i);
                            if (j * i < 10) {
                                System.out.printf("  %d   ", j * i);
                            } else {
                                System.out.printf(" %d   ", j * i);
                            }
                        }
                        System.out.println();
                    }
                } else {
                    for (int i = 1; i <= 9; i++) {
                        for (int j = S; j >= E; j--) {
                            System.out.printf("%d * %d =", j, i);
                            if (j * i < 10) {
                                System.out.printf("  %d   ", j * i);
                            } else {
                                System.out.printf(" %d   ", j * i);
                            }
                        }
                        System.out.println();
                    }
                }
                break;
            }
        }

        sc.close();
    }
}
