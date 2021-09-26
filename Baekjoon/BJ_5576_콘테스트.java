/**
 * @ BJ 5576 콘테스트
 * @ prob : https://www.acmicpc.net/problem/5576
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_5576_콘테스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] wStudentScores = new int[10];
        int[] kStudentScores = new int[10];
        for(int i = 0; i < wStudentScores.length; i++) {
            wStudentScores[i] = sc.nextInt();
        }
        for(int i = 0; i < kStudentScores.length; i++) {
            kStudentScores[i] = sc.nextInt();
        }
        Arrays.sort(wStudentScores);
        Arrays.sort(kStudentScores);
        int wScore = wStudentScores[9] + wStudentScores[8] + wStudentScores[7];
        int kScore = kStudentScores[9] + kStudentScores[8] + kStudentScores[7];
        System.out.println(wScore + " " + kScore);

        sc.close();
    }
}

// 다른 풀이 1
// 반복문 사용하여 정리

// for(int i = 0; i < 2; i++) {
//     int[] scores = new int[10];
//     for(int j = 0; j < scores.length; j++) {
//         scores[j] = sc.nextInt();
//     }
//     Arrays.sort(scores);
//     System.out.print(scores[9] + scores[8] + scores[7] + " ");
// }