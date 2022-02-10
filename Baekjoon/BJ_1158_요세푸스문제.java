/**
 * BJ 1158 요세푸스 문제
 * @ prob : https://www.acmicpc.net/problem/1158
 * @ level : S5
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");

        int cur = 0;
        while(list.size() != 0) {   // list의 원소가 모두 제거될 때까지 반복
            cur = (cur + K - 1) % list.size();      // K번째 index 찾기
            sb.append(list.remove(cur)).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        System.out.println(sb.toString());
        br.close();
    }
}

// 다른 풀이 1
// 배열을 이용해 풀이
// 배열에서 원소를 완전히 제거하지 않아 배열 전체를 돌면서 제거 여부를 확인하며 다음 K번째 원소를 찾아야 하므로 시간이 오래 걸림
// LinkedList를 이용한 풀이 : 172ms
// 배열을 이용한 풀이 : 2212ms

// int count = 0;
// int cur = -1;
// while(count != N) {     // N개 제거 후 종료
//     int k = 0;
//     // 다음 K 번째 위치 찾기
//     while(k != K) {
//         cur = (cur + 1) % N;
//         // 아직 제거되지 않았으면 체크
//         if(arr[cur] != 0) {
//             k++;
//         }
//     }
//     sb.append(arr[cur]).append(", ");
//     arr[cur] = 0;   // 제거
//     count++;
// }
