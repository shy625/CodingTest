/**
 * @ BJ 2445 별 찍기 - 8
 * @ prob : https://www.acmicpc.net/problem/2445
 */

import java.util.Scanner;

public class BJ_2445_별찍기8{
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2*(n-i); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int j = 0; j < 2*(n-i); j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// 다른 풀이 참고
// https://www.acmicpc.net/source/17945762
// https://www.acmicpc.net/source/32232955
// https://www.acmicpc.net/source/11714206