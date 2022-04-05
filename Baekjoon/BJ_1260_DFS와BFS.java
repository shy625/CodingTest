/**
 * BJ 1260 DFS와 BFS
 * @ prob : https://www.acmicpc.net/problem/1260
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

    static ArrayList<Integer>[] adjList;
    static boolean[] isVisited;
    static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        for(int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);   // 방문할 수 있는 정점이 여러 개인 경우, 작은 것부터 방문
        }

        isVisited = new boolean[N+1];
        dfs(V);

        sb.append(System.lineSeparator());

        isVisited = new boolean[N+1];
        bfs(V);

        System.out.println(sb.toString());

        br.close();
    }

    private static void dfs(int v) {
        isVisited[v] = true;
        sb.append(v + " ");
        for(int i = 0; i < adjList[v].size(); i++) {
            int nv = adjList[v].get(i);
            if(!isVisited[nv]) {
                dfs(nv);
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        isVisited[v] = true;

        while(!q.isEmpty()) {
            int cv = q.poll();
            sb.append(cv + " ");
            for(int i = 0; i < adjList[cv].size(); i++) {
                int nv = adjList[cv].get(i);
                if(!isVisited[nv]) {
                    isVisited[nv] = true;
                    q.offer(nv);
                }
            }
        }
    }
}

// 풀이 1
// ArrayList 배열로 인접리스트 구현 후 DFS, BFS 구현

// 다른 풀이 1
// 인접리스트의 노드 직접 구현
// https://www.acmicpc.net/source/39406603