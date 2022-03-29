/**
 * BJ 4153 직각삼각형
 * @ prob : https://www.acmicpc.net/problem/4153
 * @ level : B3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.charAt(0) == '0') {
                break;
            }
            st = new StringTokenizer(input, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            int max = Math.max(x, Math.max(y, z));
            int powSum = x * x + y * y + z * z;
            if(powSum == 2 * max * max) {
                sb.append("right");
            } else {
                sb.append("wrong");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}
