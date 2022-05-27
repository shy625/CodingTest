/**
 * BJ 20299 3대 측정
 * @ prob : https://www.acmicpc.net/problem/20299
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20299_3대측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int VIPCount = 0;
        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            st = new StringTokenizer(team);
            boolean isVIP = true;
            int rateSum = 0;
            for (int j = 0; j < 3; j++) {
                int rate = Integer.parseInt(st.nextToken());
                if (rate < L) {
                    isVIP = false;
                    break;
                }
                rateSum += rate;
            }
            if (isVIP && rateSum >= K) {
                VIPCount++;
                sb.append(team + " ");
            }
        }

        sb.insert(0, VIPCount + System.lineSeparator());

        System.out.println(sb.toString());

        br.close();
    }
}
