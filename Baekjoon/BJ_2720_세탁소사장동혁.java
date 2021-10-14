/**
 * @ BJ 2720 세탁소 사장 동혁
 * @ prob : https://www.acmicpc.net/problem/2720
 */

import java.util.Scanner;

public class BJ_2720_세탁소사장동혁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int[] result = calculateChange(sc.nextInt());
            System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
        }

        sc.close();
    }
    static int[] calculateChange(int change) {
        int[] coins = {25, 10, 5, 1};
        int[] result = new int[4];
        for(int i = 0; i < coins.length; i++) {
            result[i] = change / coins[i];
            change %= coins[i];
        }
        return result;
    }
}