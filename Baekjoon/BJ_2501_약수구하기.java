/**
 * @ BJ 2501 약수 구하기
 * @ prob : https://www.acmicpc.net/problem/2501
 */

import java.util.Scanner;

public class BJ_2501_약수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();

        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
            if(count == k) {
                System.out.println(i);
                break;
            }
        }
        if(count < k) {
            System.out.println(0);
        }

        sc.close();
    }
}