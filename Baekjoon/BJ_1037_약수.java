/**
 * @ BJ 1037 약수
 * @ prob : https://www.acmicpc.net/problem/1037
 */

import java.util.*;

public class BJ_1037_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] divisors = new int[n];

        for(int i = 0; i < n; i++) {
            divisors[i] = sc.nextInt();
        }
        Arrays.sort(divisors);
        System.out.println(divisors[0] * divisors[n-1]);

        sc.close();
    }
}