/**
 * BJ 2805 나무 자르기
 * @ prob : https://www.acmicpc.net/problem/2805
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Integer[] trees = new Integer[N];
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int min = 0;
        while(min <= max) {
            int mid = (max + min) / 2;

            long sum = 0;
            for(int i = 0; i < N; i++) {
                sum += trees[i] - mid >= 0 ? trees[i] - mid : 0;
            }

            if(sum >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println((max + min) / 2);

        br.close();
    }
}

// 다른 풀이 1
// 이분 탐색의 다른 로직들
// https://www.acmicpc.net/source/5879255
// https://www.acmicpc.net/source/22710961