/**
 * @ BJ 1546 평균
 * @ prob : https://www.acmicpc.net/problem/1546
 */

import java.util.Scanner;

public class BJ_1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0, max = 0;
        double newAvg = 0;
        for(int i = 0; i < n; i++) {
            int score = sc.nextInt();
            if(score > max) {
                max = score;
            }
            sum += score;
        }
        newAvg = (sum * 100.0) / (max * n);
        System.out.println(newAvg);;

        sc.close();
    }
}