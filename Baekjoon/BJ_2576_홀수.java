/**
 * @ BJ 2576 홀수
 * @ prob : https://www.acmicpc.net/problem/2576
 */

import java.util.Scanner;

public class BJ_2576_홀수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = 100, sum = 0;
        for(int i = 0; i < 7; i++) {
            int num = sc.nextInt();
            if(num % 2 == 1) {
                if(num < min) {
                    min = num;
                }
                sum += num;
            }
        }
        System.out.println(sum == 0 ? -1 : sum + "\n" + min);

        sc.close();
    }
}