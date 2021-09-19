/**
 * @ BJ 2953 나는 요리사다
 * @ prob : https://www.acmicpc.net/problem/2953
 */

import java.util.Scanner;

public class BJ_2953_나는요리사다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] score = new int[5];
        int max = 0;
        for(int i = 0; i < score.length; i++) {
            score[i] = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
            if(score[i] > score[max]) {
                max = i;
            }
        }
        System.out.println(max+1 + " " + score[max]);

        sc.close();
    }
}