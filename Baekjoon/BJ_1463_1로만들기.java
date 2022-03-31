/**
 * BJ 1463 1로 만들기
 * @ prob : https://www.acmicpc.net/problem/1463
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] x = new int[N+1];
        
        // DP
        x[0] = 0;
        x[1] = 0;
        for(int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0) {
                min = Math.min(min, x[i/3]);
            }
            if(i % 2 == 0) {
                min = Math.min(min, x[i/2]);
            }
            min = Math.min(min, x[i-1]);
            x[i] = min + 1;
        }
        System.out.println(x[N]);

        br.close();
    }
}

// 풀이 1
// DP 점화식
// f(x) = min(x % 3 == 0 then f(x/3), x % 2 == 0 then f(x/2), f(x-1)) + 1
// f(0) = 0, f(1) = 0