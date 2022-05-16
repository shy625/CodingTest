/**
 * BJ 25193 곰곰이의 식단 관리
 * @ prob : https://www.acmicpc.net/problem/25193
 * @ level : S5
 * 제1회 곰곰컵 C번
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_25193_곰곰이의식단관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] foods = br.readLine().toCharArray();
        int chickenCnt = 0, otherCnt = 0;

        for (int i = 0; i < N; i++) {
            if (foods[i] == 'C') {
                chickenCnt++;
            } else {
                otherCnt++;
            }
        }
        int stream = chickenCnt / (otherCnt + 1);
        if (chickenCnt % (otherCnt + 1) > 0) {
            stream++;
        }

        System.out.println(stream);

        br.close();
    }   
}

// 풀이 1
// 치킨을 먹는 날을 치킨을 먹지 않는 날 사이에 균등하게 분배할 때 치킨을 먹는 연속일 수를 최소로 할 수 있음
// 따라서 치킨 먹는 날 / 치킨을 먹지 않는 날로 나누고
// 만약 나머지가 있다면 나눈 결과에 +1을 해주면 된다.