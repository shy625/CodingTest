/**
 * SWEA 2805 농작물 수확하기
 * @ prob : https://bit.ly/3omYHgs
 * @ level : D3
 */

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            char[][] farm = new char[n][n];
            for(int i = 0; i < n; i++) {
                String line = sc.next();
                farm[i] = line.toCharArray();
            }

            int sum = 0;
            for(int i = 0; i <= n/2; i++) {
                for(int j = n/2-i; j <= n/2+i; j++) {
                    sum += farm[i][j] - '0';
                }
            }
            for(int i = n/2+1; i < n; i++) {
                for(int j = n/2-(n-1-i); j <= n/2+(n-1-i); j++) {
                    sum += farm[i][j] - '0';
                }
            }
            System.out.println("#" + t + " " + sum);
        }
        
        sc.close();
    }
}