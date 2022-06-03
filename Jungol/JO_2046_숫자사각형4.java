/**
 * JO 2046 숫자사각형4
 * @ prob : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1316&sca=20
 * @ level : 
 */

import java.util.Scanner;

public class JO_2046_숫자사각형4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        printSquare(N, M);

        sc.close();
    }

    private static void printSquare(int N, int M) {
        int[][] square = new int[N][N];
        switch (M) {
            case 1:
                square1(square);
                break;
            case 2:
                square2(square);
                break;
            case 3:
                square3(square);
                break;
        }
        print(square);
    }
    
    private static void square1(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = i + 1;
            }
        }
    }

    private static void square2(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    square[i][j] = n - j;
                }
            }
        }
    }

    private static void square3(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    square[i][j] = j + 1;
                } else if (j == 0) {
                    square[i][j] = i + 1;
                } else {
                    square[i][j] = (i + 1) * (j + 1);
                }
            }
        }
    }

    private static void print(int[][] square) {
        int n = square.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }
}
