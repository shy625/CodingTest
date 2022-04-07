/**
 * BJ 1764 듣보잡
 * @ prob : https://www.acmicpc.net/problem/1764
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(!set.add(input)) {   // add() 시 이미 있는 원소여서 false가 나오면 리스트에 추가
                list.add(input);
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append(System.lineSeparator());
        for(String name : list) {
            sb.append(name).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// HashSet 이용하여 중복 판단
// HashSet에 첫번째 명단을 다 넣고, 두번째 명단을 다 넣을 때 중복이 발생하여 false가 리턴되면 해당 이름을 리스트에 저장
// HashSet의 add() 메소드의 시간복잡도는 O(1) <- 내부적으로 HashMap을 이용해 구현되어 있음
// 따라서 전체 시간복잡도는 첫번째 명단 N개와 두번째 명단 M개를 add() 하는 것이므로 O(N+M)의 시간복잡도를 가짐

// 다른 풀이 1
// 첫번째 명단과 두번쨰 명단 각각 배열에 저장
// 두 배열 정렬 후 사전순에 따라 첫번쨰 배열의 인덱스 또는 두번쨰 배열의 인덱스를 옮겨가며 중복되는지 확인
// O(N+M)
// https://www.acmicpc.net/source/26064653

// 다른 풀이 2
// 두 명단을 한 배열에 넣고 정렬
// 앞에서부터 자신과 자신 다음 것을 비교하며 동일한 것이 있는지 확인하여 출력
// O(N+M)
// https://www.acmicpc.net/source/7133126