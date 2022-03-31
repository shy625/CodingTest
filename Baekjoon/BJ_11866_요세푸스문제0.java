/**
 * BJ 11866 요세푸스 문제 0
 * @ prob : https://www.acmicpc.net/problem/11866
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = -1;
        while(!list.isEmpty()) {
            idx = (idx + K) % list.size();
            sb.append(list.remove(idx)).append(", ");
            idx--;
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// 자료구조의 크기가 가변적이므로 배열 < 리스트
// 삭제가 빈번히 발생하므로 ArrayList < LinkedList
// 따라서 LinkedList가 ArrayList보다 더 효율적이라고 생각했으나 결과는 반대
// ArrayList -> 124ms
// LinkedList -> 132ms
// Why?
// LinkedList를 사용했을 때 삭제에서 얻는 이득보다
// ArrayList를 사용했을 때 삭제하고자 하는 리스트 원소 index에 바로 접근하므로서 얻는 이득이 더 큼
// + 리스트 크기가 충분히 크지 않아 원소를 삭제할 때 드는 비용이 그리 크지 않음