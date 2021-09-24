/**
 * @ BJ 9076 점수 집계
 * @ prob : https://www.acmicpc.net/problem/9076
 */

import java.util.*;

public class BJ_9076_점수집계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int[] scores = new int[5];
            for(int j = 0; j < scores.length; j++) {
                scores[j] = sc.nextInt();
            }
            Arrays.sort(scores);
            if(scores[3] - scores[1] >= 4) {
                System.out.println("KIN");
            } else {
                int sum = scores[1] + scores[2] + scores[3];
                System.out.println(sum);
            }
        }

        sc.close();
    }
}