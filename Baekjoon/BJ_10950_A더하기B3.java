/**
 * @ BJ 10950 A+B - 3
 * @ prob : https://www.acmicpc.net/problem/10950
 */

import java.util.Scanner;

public class BJ_10950_A더하기B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }

        sc.close();
    }
}