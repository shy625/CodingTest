/**
 * BJ 11399 ATM
 * @ prob : https://www.acmicpc.net/problem/11399
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += P[i] * (N - i);  // i번째 선택된 사람의 소요시간은 이후 사람들의 대기시간에 포함
        }

        System.out.println(sum);

        br.close();
    }
}

// 풀이 1
// SJF 알고리즘 이용