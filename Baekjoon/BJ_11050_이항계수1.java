/**
 * BJ 11050 이항 계수 1
 * @ prob : https://www.acmicpc.net/problem/11050
 * @ level : B1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int c = 1;
        for(int k = 1, n = N; k <= K; k++, n--) {
            c *= n;
            c /= k;
        }
        System.out.print(c);
        
        br.close();
    }
}

// 풀이
// NCK 계산