/**
 * @ BJ 10984 내 학점을 구해줘
 * @ prob : https://www.acmicpc.net/problem/10984
 */

import java.util.Scanner;

public class BJ_10984_내학점을구해줘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int sumC = 0;
            float sumG = 0f;
            for(int j = 0; j < n; j++) {
                int c = sc.nextInt();
                sumG += sc.nextFloat() * c;
                sumC += c;
            }
            System.out.printf("%d %.1f\n", sumC, sumG/sumC);
        }

        sc.close();
    }
}