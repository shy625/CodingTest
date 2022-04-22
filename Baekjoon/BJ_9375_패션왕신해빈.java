/**
 * BJ 9375 패션왕 신해빈
 * @ prob : https://www.acmicpc.net/problem/9375
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();   // unused
                String category = st.nextToken();
                hashMap.put(category, hashMap.getOrDefault(category, 0) + 1);   // HashMap을 이용해 카테고리별 아이템 개수 구하기
            }

            int count = 1;
            for(String key : hashMap.keySet()) {
                count *= hashMap.get(key) + 1;
            }

            sb.append(count - 1).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1 - 메모리 초과
// 카테고리에 대해 부분집합 이용
// 입은 카테고리의 아이템 개수를 곱해서 더하기, 마지막에 모두 안 입은 경우 1 빼기
// https://www.acmicpc.net/source/42360292

// 풀이 2
// 각 카테고리의 아이템 개수에 안 입은 경우를 더해서 모두 곱하기 - 1(모두 안 입은 경우 제외)
// https://daebalpri.me/entry/BOJ-9375-%ED%8C%A8%EC%85%98%EC%99%95-%EC%8B%A0%ED%95%B4%EB%B9%88