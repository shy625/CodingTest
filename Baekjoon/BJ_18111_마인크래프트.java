/**
 * BJ 18111 마인크래프트
 * @ prob : https://www.acmicpc.net/problem/18111
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] land = new int[N*M];
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < M; c++) {
                land[r * M + c] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(land);

        int min = land[0];
        int max = land[N*M-1];
        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for(int i = min; i <= max; i++) {
            int over = 0;
            int under = 0;
            for(int j = N*M-1; j >= 0; j--) {
                if(land[j] > i) {
                    over += land[j] - i;
                }
                if(land[j] < i) {
                    under += i - land[j];
                }
            }
            if(over + B >= under) {
                int time = under + over * 2;
                if(time <= minTime) {
                    minTime = time;
                    height = i;
                }
            } else {
                break;
            }
        }
        System.out.println(minTime + " " + height);

        br.close();
    }
}

// 플이 1
// 1차원 배열로 받아 높이 순으로 오름차순 정렬
// 최소 높이부터 최대 높이까지 각 높이에 대해 시간 계산
// 제거하는 블록 + 주어진 땅 < 채우는 블록 이 되면 반복 종료

// 다른 풀이 1
// 땅의 높이 범위로 배열을 만들고 해당 높이의 땅을 count 하는 방법으로 정렬
// 낮은 높이부터 차례대로 시간 계산
// https://www.acmicpc.net/source/26083829