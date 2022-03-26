/**
 * BJ 2164 카드2
 * @ prob : https://www.acmicpc.net/problem/2164
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            cards.offer(i);
        }

        while(cards.size() > 1) {
            cards.poll();
            cards.offer(cards.poll());
        }
        System.out.println(cards.poll());

        br.close();
    }
}

// 풀이 1
// Queue를 이용한 풀이

// 다른 풀이 1
// 규칙을 찾아서 풀이
// https://www.acmicpc.net/source/26105300
