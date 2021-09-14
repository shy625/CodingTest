/**
 * @ BJ 2562 최댓값
 * @ prob : https://www.acmicpc.net/problem/2562
 */

import java.util.Scanner;

public class BJ_2562_최댓값 { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = -1, pos = -1;
        for(int i = 1; i <= 9; i++) {
            int tmp = sc.nextInt();
            if(tmp > max) {
                max = tmp;
                pos = i;
            }
        }
        System.out.println(max + "\n" + pos);

        sc.close();
    }
}