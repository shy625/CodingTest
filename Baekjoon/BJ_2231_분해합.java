/**
 * BJ 2231 분해합
 * @ prob : https://www.acmicpc.net/problem/2231
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int min = N - input.length() * 9;
        for(int i = min; i <= N; i++) {
            int sum = i;
            for(int j = i; j > 0; j = j / 10) {
                sum += j % 10;
            }
            if(sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}

// 풀이 1
// 모든 자리수가 9일 때가 가장 작은 분해값 -> 주어진 수에 자리수 * 9 를 뺀 수부터 분해값 찾기 시작

// 다른 풀이 1
// 자리수 확인에 log10 사용
// https://www.acmicpc.net/source/12600871

// int jali = (int)Math.log10(N);