/**
 * BJ 11724 연결 요소의 개수
 * @ prob : https://www.acmicpc.net/problem/11724
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {

    static List<Integer>[] adjList;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        isVisited = new boolean[N+1];
        
        int count = 0;
        for(int i = 1; i < adjList.length; i++) {
            if(!isVisited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);

        br.close();
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        isVisited[v] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < adjList[cur].size(); i++) {
                int next = adjList[cur].get(i);
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}

// 풀이 1
// BFS 사용 (DFS로도 동일 로직 가능)
// 각 정점을 시작점으로 하여 BFS 진행 -> 해당 정점과 연결된 정점들 방문 처리 -> 연결 요소 개수 + 1
// 방문 처리되지 않은 다른 정점을 시작점으로 하여 BFS 진행

// 다른 풀이 1
// Union-Find 사용
// 연결 요소 개수 = 정점의 개수 로 시작
// 간선이 들어오는대로 Union-Find 진행
// Union에 성공하면 연결 요소 개수 - 1
// https://www.acmicpc.net/source/41399183