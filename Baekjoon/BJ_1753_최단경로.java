/**
 * BJ 1753 최단경로
 * @ prob : https://www.acmicpc.net/problem/1753
 * @ level : G5
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {

    static class Vertex implements Comparable<Vertex> {
        int num;    // 정점의 번호
        int weight; // 정점으로의 가중치
        Vertex link;

        Vertex(int num, int weight, Vertex link) {
            this.num = num;
            this.weight = weight;
            this.link = link;
        }

        @Override
        public int compareTo(Vertex o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int start = Integer.parseInt(br.readLine());    // 시작 정점

        // 그래프의 인접리스트 초기화
        Vertex[] adjList = new Vertex[V+1];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from] = new Vertex(to, weight, adjList[from]);  // 단방향 그래프
        }

        // Dijkstra - PQ
        int[] distance = new int[V+1];      // 시작점에서 해당 정점까지 오는 경로의 최소비용
        boolean[] isChecked = new boolean[V+1];     // 최소비용 확정 여부
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.offer(new Vertex(start, distance[start], null));

        while(!pq.isEmpty()) {
            // 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
            Vertex cur = pq.poll();
            if(isChecked[cur.num]) {
                continue;
            }

            // 최소비용 확정 체크
            isChecked[cur.num] = true;

            // 새로 선택된 정점을 경유지로 하여 다른 정점들의 최소 비용 업데이트
            for(Vertex next = adjList[cur.num]; next != null; next = next.link) {
                if(!isChecked[next.num] && distance[next.num] > distance[cur.num] + next.weight) {
                    distance[next.num] = distance[cur.num] + next.weight;
                    pq.offer(new Vertex(next.num, distance[next.num], null));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            sb.append(distance[i] != Integer.MAX_VALUE ? distance[i] : "INF").append('\n');
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// 기본 다익스트라를 이용한 풀이
// https://www.acmicpc.net/source/39553897
// 1984ms

// 풀이 2
// Priority Queue를 이용한 다익스트라 풀이
// 위 코드
// 720ms

// 풀이 3
// ArrayList의 배열을 이용해 구현한 인접리스트 + 다익스트라 with PQ의 풀이
// https://www.acmicpc.net/source/39579498
// 804ms