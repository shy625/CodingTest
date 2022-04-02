/**
 * BJ 1003 피보나치 함수
 * @ prob : https://www.acmicpc.net/problem/1003
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] fiboCount = new int[41][2];

        fiboCount[0][0] = 1;
        fiboCount[1][1] = 1;
        for(int i = 2; i <= 40; i++) {
            fiboCount[i][0] = fiboCount[i-1][0] + fiboCount[i-2][0];
            fiboCount[i][1] = fiboCount[i-1][1] + fiboCount[i-2][1];
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fiboCount[N][0] + " " + fiboCount[N][1]).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// DP을 이용해 배열에 40까지의 0, 1 호출수를 미리 저장