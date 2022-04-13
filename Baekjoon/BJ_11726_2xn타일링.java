/**
 * BJ 11726 2xn 타일링
 * @ prob : https://www.acmicpc.net/problem/11726
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726_2xn타일링 {

    static final int DIVISOR =  10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] fibo = new int[N+1];

        fibo[0] = 1;
        fibo[1] = 1;
        for(int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % DIVISOR;
        }

        System.out.println(fibo[N]);

        br.close();
    }
}

// 풀이 1
// 피보나치 수열 + DP 사용