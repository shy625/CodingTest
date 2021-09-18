/**
 * @ BJ 2460 지능형 기차 2
 * @ prob : https://www.acmicpc.net/problem/2460
 */

import java.util.Scanner;

public class BJ_2460_지능형기차2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int peopleNum = 0, max = 0;
        for(int i = 0; i < 10; i++) {
            peopleNum -= sc.nextInt();
            peopleNum += sc.nextInt();
            if(peopleNum > max) {
                max = peopleNum;
            }
        }
        System.out.println(max);

        sc.close();
    }
}