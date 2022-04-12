/**
 * BJ 11279 최대 힙
 * @ prob : https://www.acmicpc.net/problem/11279
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if(val > 0) {
                pq.offer(val);
            } else {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// Java의 힙 자료구조인 PriorityQueue 사용 - reverseOrder

// 다른 풀이 1
// 배열로 Heap 자료구조 직접 구현
// https://www.acmicpc.net/source/39801473