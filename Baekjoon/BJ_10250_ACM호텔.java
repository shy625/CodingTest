/**
 * BJ 10250 ACM 호텔
 * @ prob : https://www.acmicpc.net/problem/10250
 * @ level : B3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250_ACM호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;
            outer :
            for(int c = 1; c <= W; c++) {
                for(int r = 1; r <= H; r++) {
                    count++;
                    if(count == N) {
                        sb.append(r).append(String.format("%02d", c)).append(System.lineSeparator());
                        break outer;
                    }
                }
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}
