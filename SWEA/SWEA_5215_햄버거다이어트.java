/**
 * SWEA 5215 햄버거 다이어트
 * @ prob : https://bit.ly/34Dlmyn
 * @ level : D3
 * @ blog : 
 */

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {

    static int N, L;
    static int[] scores, calories;
    static int scoreSum, calorieSum;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            L = sc.nextInt();

            scores = new int[N];
            calories = new int[N];

            for(int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
            }

            max = -1;
            // for(int i = 0; i <= 0; i++) {
            //     combi(0, 0, i, 0, 0);
            // }
            subset(0, 0, 0);

            System.out.println("#" + t + " " + max);
        }

        sc.close();
    }

    // 조합
    static void combi(int count, int start, int R, int scoreSum, int calorieSum) {
        if(count == R) {
            if(calorieSum <= L) {
                max = Math.max(max, scoreSum);
            }
            return;
        }
        for(int i = start; i < N; i++) {
            combi(count + 1, i + 1, R, scoreSum + scores[i], calorieSum + calories[i]);
        }
    }

    // 부분집합
    static void subset(int index, int scoreSum, int calorieSum) {
        if(index == N) {
            if(calorieSum <= L) {
                max = Math.max(max, scoreSum);
            }
            return;
        }
        // 현재 원소 선택
        subset(index + 1, scoreSum + scores[index], calorieSum + calories[index]);
        // 현재 원소 비선택
        subset(index + 1, scoreSum, calorieSum);
    }
}

// nCr에서 r을 0 -> n 반복 == 부분집합