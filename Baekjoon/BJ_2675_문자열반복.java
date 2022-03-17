/**
 * BJ 2675 문자열 반복
 * @ prob : https://www.acmicpc.net/problem/2675
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675_문자열반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < S.length(); i++) {
                for(int r = 0; r < R; r++) {
                    sb.append(S.charAt(i));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
