/**
 * @ BJ 2455 지능형 기차
 * @ prob : https://www.acmicpc.net/problem/2455
 */

import java.util.Scanner;

public class BJ_2455_지능형기차 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 0, max = 0;
        for(int i = 0; i < 4; i++) {
            num -= sc.nextInt();
            num += sc.nextInt();
            if(num > max) {
                max = num;
            }
        }
        System.out.println(max);

        sc.close();
    }
}