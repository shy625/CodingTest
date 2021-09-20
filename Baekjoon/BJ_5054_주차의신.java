/**
 * @ BJ 5054 주차의 신
 * @ prob : https://www.acmicpc.net/problem/5054
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_5054_주차의신 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] stores = new int[n];
            for(int j = 0; j < stores.length; j++) {
                stores[j] = sc.nextInt();
            }
            Arrays.sort(stores);
            int diff = stores[stores.length-1]-stores[0];
            System.out.println(diff*2);
        }

        sc.close();
    }
}