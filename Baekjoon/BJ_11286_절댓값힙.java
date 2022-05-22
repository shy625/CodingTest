/**
 * BJ 11286 절댓값 힙
 * @ prob : https://www.acmicpc.net/problem/11286
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            // PQ의 정렬 기준을 절댓값으로 변경
            // 절댓값이 가장 작은 값이 root
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {   // 출력
                if (pq.size() == 0) {   // PQ의 크기가 0인 경우
                    sb.append(0);
                } else {    // PQ의 크기가 0이 아닌 경우
                    int out = pq.poll();    // 절댓값이 가장 작은 값 뽑기
                    if (out > 0) {  // 값이 양수면 동일한 절댓값의 음수가 있는지 확인
                        if (pq.contains(-out)) {    // 있다면 양수는 다시 넣고 음수 제거
                            pq.offer(out);
                            pq.remove(-out);
                            out *= -1;
                        }
                    }
                    sb.append(out);
                }
                sb.append(System.lineSeparator());
            } else {    // 입력
                pq.offer(x);
            }
        }

        System.out.println(sb.toString());

        br.close();
    }   
}

// 풀이 1
// Priority Queue 사용
// PQ의 정렬 기준을 절댓값의 오름차순으로 설정
// 출력 시 절댓값이 가장 작은 값을 뽑고, 뽑은 수가 양수면 동일한 절댓값의 음수가 있는지 확인
// 음수가 있다면 뽑은 양수는 다시 넣고 음수를 제거한 뒤 출력
// 동일한 음수가 없거나 처음에 뽑은 값이 음수라면 그대로 출력

// 다른 풀이 1
// Heap을 직접 구현하여 풀이
// https://www.acmicpc.net/source/39810110

// 다른 풀이 2
// 절댓값과 원래 값을 둘 다 멤버 변수로 가지는 클래스 생성
// 해당 클래스를 PQ에 저장
// 1차로 절댓값을 비교하여 오른차순 정렬, 절댓값이 같다면 2차로 원래 값을 비교하여 오름차순 정렬
// https://www.acmicpc.net/source/9130454