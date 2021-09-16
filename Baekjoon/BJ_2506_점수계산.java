/**
 * @ BJ 2506 점수계산
 * @ prob : https://www.acmicpc.net/problem/2506
 */

import java.util.Scanner;

public class BJ_2506_점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0, score = 1;
        for(int i = 0; i < n; i++) {
            int prob = sc.nextInt();
            if(prob == 0) {
                score = 1;
            } else {
                sum += score;
                score++;
            }
        }
        System.out.println(sum);

        sc.close();
    }
}