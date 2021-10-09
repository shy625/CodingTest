/**
 * @ BJ 5597 과제 안 내신 분..?
 * @ prob : https://www.acmicpc.net/problem/5597
 */

import java.util.Scanner;

public class BJ_5597_과제안내신분 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] hadSubmited = new boolean[31];
        for(int i = 0; i < 28; i++) {
            hadSubmited[sc.nextInt()] = true;
        }
        for(int i = 1; i < hadSubmited.length; i++) {
            if(!hadSubmited[i]) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}