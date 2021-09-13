/**
 * @ BJ 1978 소수 찾기
 * @ prob : https://www.acmicpc.net/problem/1978
 */

import java.util.Scanner;

public class BJ_1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(isPrime(sc.nextInt())) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++) { // 에라토스테네스의 체
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}