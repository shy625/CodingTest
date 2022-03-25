/**
 * BJ 1654 랜선 자르기
 * @ prob : https://www.acmicpc.net/problem/1654
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] lines = new int[K];
        long total = 0;
        for(int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            total += lines[i];
        }

        long max = total / N;
        long min = 1L;
        while(min <= max) {
            long mid = (max + min) / 2;
            
            int count = 0;
            for(int i = 0; i < K; i++) {
                count += lines[i] / mid;
            }

            if(count >= N) {    // 길이 늘리기
                min = mid + 1;
            } else {    // 길이 줄이기
                max = mid - 1;
            }
        }
        System.out.println((max + min) / 2);

        br.close();
    }
}

// 풀이 1
// 이분탐색 이용

// 풀이 2
// 이분탐색 이용 - 풀이 1 개선