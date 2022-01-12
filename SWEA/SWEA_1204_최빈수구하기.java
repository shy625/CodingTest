/**
 * @ SWEA 1204 최빈수 구하기
 * @ prob : https://bit.ly/335MBBh
 * @ level : D2
 */

import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int[] scoreFreq = new int[101];
            int n = sc.nextInt();
            int mostFreqCount = 0;
            int mostFreqScore = 0;
            for(int j = 0; j < 1000; j++) {
                int score = sc.nextInt();
                scoreFreq[score]++;
                if(scoreFreq[score] > mostFreqCount) {
                    mostFreqCount = scoreFreq[score];
                    mostFreqScore = score;
                } else if(scoreFreq[score] == mostFreqCount) {
                    if(score > mostFreqScore) {
                        mostFreqScore = score;
                    }
                }
            }
            System.out.println("#" + n + " " + mostFreqScore);
        }

        sc.close();
    }
}