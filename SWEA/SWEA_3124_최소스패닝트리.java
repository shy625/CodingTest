/**
 * SWEA 3124 최소 스패닝 트리
 * @ prob : https://bit.ly/3DA8q9V
 * @ level : D4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[E];
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edges);
            int[] parents = new int[V+1];
            makeSet(parents);
            long sum = 0, count = 0;

            for(int i = 0; i < E; i++) {
                if(union(parents, edges[i].from, edges[i].to)) {
                    sum += edges[i].weight;
                    count++;
                }
                if(count == V-1) {
                    break;
                }
            }
            sb.append("#" + t + " " + sum).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    private static void makeSet(int[] parents) {
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int[] parents, int v) {
        if(parents[v] == v) {
            return v;
        }
        return parents[v] = findSet(parents, parents[v]);
    }

    private static boolean union(int[] parents, int v1, int v2) {
        int root1 = findSet(parents, v1);
        int root2 = findSet(parents, v2);
        if(root1 != root2) {
            parents[root2] = root1;
            return true;
        } else {
            return false;
        }
    }
}

// 풀이 1
// Kruskal Algorithm

// 풀이 2
// Prim's Algorithm