/**
 * BJ 7662 이중 우선순위 큐
 * @ prob : https://www.acmicpc.net/problem/7662
 * @ level : G4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>();    // <입력 데이터, 입력 데이터의 개수>

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            for(int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                String comm = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if(comm.equals("I")) {      // 삽입
                    if(map.containsKey(val)) {
                        int count = map.get(val);
                        map.put(val, ++count);
                    } else {
                        map.put(val, 1);
                    }
                } else {    // 삭제
                    if(!map.isEmpty()) {
                        if(val == 1) {
                            int key = map.lastKey();
                            int count = map.get(key);
                            if(count > 1) {
                                map.put(key, --count);
                            } else {
                                map.remove(key);
                            }
                        } else {
                            int key = map.firstKey();
                            int count = map.get(key);
                            if(count > 1) {
                                map.put(key, --count);
                            } else {
                                map.remove(key);
                            }
                        }
                    }
                }
            }
            if(!map.isEmpty()) {
                sb.append(map.lastKey() + " " + map.firstKey());
            } else {
                sb.append("EMPTY");
            }
            sb.append(System.lineSeparator());

            map.clear();
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1 - 시간초과
// 2개의 PriorityQueue 이용
// minPQ와 maxPQ를 가지고 각각 min, max 값을 구하면 해당 값을 다른 PQ에서도 찾아서 remove
// remove()가 O(N)의 시간복잡도를 가지기 때문에 시간초과 발생
// https://www.acmicpc.net/source/41761008

// 풀이 2
// TreeMap 이용
// TreeMap : <Key, Value>를 Key에 대한 이진트리 구조로 저장 -> 정렬된 상태를 유지하여 최댓값, 최솟값을 찾는 함수 제공
// <입력 데이터, 데이터의 개수> 로 HashMap에 저장.
// 최솟값, 최댓값을 별도로 관리할 필요없이 하나의 자료구조에서 O(logN)에 접근 가능