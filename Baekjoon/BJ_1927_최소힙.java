/**
 * BJ 1927 최소 힙
 * @ prob : https://www.acmicpc.net/problem/1927
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                int output = 0;
                if(!pq.isEmpty()) {
                    output = pq.poll();
                } 
                sb.append(output).append(System.lineSeparator());
            } else {
                pq.offer(input);
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// Java의 Heap 자료구조인 PriorityQueue 사용

// 다른 풀이 1
// 배열을 이용해 Heap 자료구조 직접 구현
// https://www.acmicpc.net/source/39809486