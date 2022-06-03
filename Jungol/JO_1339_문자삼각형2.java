/**
 * JO 1339 문자삼각형2
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2075&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_1339_문자삼각형2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[][] charTriangle = new char[N][N];
        char alpha = 'A';

        if(!checkInput(N)) {
            System.out.println("INPUT ERROR");
        } else {
            for (int j = N / 2; j >= 0; j--) {
                for (int i = j; i < N - j; i++) {
                    charTriangle[i][j] = alpha++;
                    if (alpha > 'Z') {
                        alpha = 'A';
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (charTriangle[i][j] == '\0') {
                        break;
                    }
                    System.out.print(charTriangle[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }

    private static boolean checkInput(int N) {
        return 1 <= N && N <= 100 && N % 2 == 1;
    }
}
