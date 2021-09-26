/**
 * @ BJ 5800 성적 통계
 * @ prob : https://www.acmicpc.net/problem/5800
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_5800_성적통계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] scores = new int[n];
            for(int j = 0; j < scores.length; j++) {
                scores[j] = sc.nextInt();
            }
            Arrays.sort(scores);
            int maxGap = 0;
            for(int j = scores.length-1; j >= 1; j--) {
                maxGap = Math.max(maxGap, scores[j] - scores[j-1]);
            }
            System.out.printf("Class %d\n", i+1);
            System.out.printf("Max %d, Min %d, Largest gap %d\n", scores[scores.length-1], scores[0], maxGap);
        }

        sc.close();
    }
}