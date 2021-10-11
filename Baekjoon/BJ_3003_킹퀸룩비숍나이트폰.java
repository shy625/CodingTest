/**
 * @ BJ 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
 * @ prob : https://www.acmicpc.net/problem/3003
 */

import java.util.Scanner;

public class BJ_3003_킹퀸룩비숍나이트폰 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rightChessPieces = {1, 1, 2, 2, 2, 8};
        int[] chessPieces = new int[6];

        for(int i = 0; i < 6; i++) {
            chessPieces[i] = sc.nextInt();
        }

        for(int i = 0; i < 6; i++) {
            System.out.print((rightChessPieces[i] - chessPieces[i]) + " ");
        }

        sc.close();
    }
}