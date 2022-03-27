/**
 * BJ 2798 블랙잭
 * @ prob : https://www.acmicpc.net/problem/2798
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int maxUnderM = 0;
        // 조합 - nC3
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= M) {
                        maxUnderM = Math.max(maxUnderM, sum);
                    }
                }
            }
        }

        System.out.println(maxUnderM);

        br.close();
    }
}
