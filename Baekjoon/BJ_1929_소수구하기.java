/**
 * BJ 1929 소수 구하기
 * @ prob : https://www.acmicpc.net/problem/1929
 * @ level : S3
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] primes = getPrimes(N);
        for(int i = M; i <= N; i++) {
            if(primes[i]) {
                sb.append(i).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());

        sc.close();
    }

    // 에라토스테네스의 체
    private static boolean[] getPrimes(int max) {
        boolean[] primes = new boolean[max+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i <= max; i++) {
            if(primes[i]) {
                for(int j = 2; i*j <= max; j++) {
                    primes[i*j] = false;
                }
            }
        }
        return primes;
    }
}
