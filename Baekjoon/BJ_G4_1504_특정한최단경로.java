import java.io.*;
import java.util.*;

public class BJ_G4_1504_특정한최단경로 {

    private static class Node implements Comparable<Node> {
        int num;
        int distance;

        private Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.distance, n.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new int[] { b, c });
            adjList[b].add(new int[] { a, c });
        }

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()) - 1;
        int w = Integer.parseInt(st.nextToken()) - 1;

        int[] minDistanceS = getMinDistance(adjList, 0);
        int[] minDistanceV = getMinDistance(adjList, v);
        int[] minDistanceW = getMinDistance(adjList, w);
        
        int path1 = 0;
        if (minDistanceS[v] == Integer.MAX_VALUE
                || minDistanceV[w] == Integer.MAX_VALUE
                || minDistanceW[n - 1] == Integer.MAX_VALUE) {
            path1 = Integer.MAX_VALUE;
        } else {
            path1 = minDistanceS[v] + minDistanceV[w] + minDistanceW[n - 1];
        }

        int path2 = 0;
        if (minDistanceS[w] == Integer.MAX_VALUE
                || minDistanceW[v] == Integer.MAX_VALUE
                || minDistanceV[n - 1] == Integer.MAX_VALUE) {
            path2 = Integer.MAX_VALUE;
        } else {
            path2 = minDistanceS[w] + minDistanceW[v] + minDistanceV[n - 1];
        }

        int result = Math.min(path1, path2);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

        br.close();
    }
    
    private static int[] getMinDistance(List<int[]>[] adjList, int start) {
        int n = adjList.length;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isChecked = new boolean[n];
        int[] minDistance = new int[n];

        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (isChecked[cur.num]) {
                continue;
            }
            isChecked[cur.num] = true;
            for (int[] next : adjList[cur.num]) {
                if (!isChecked[next[0]] && minDistance[next[0]] > minDistance[cur.num] + next[1]) {
                    minDistance[next[0]] = minDistance[cur.num] + next[1];
                    pq.offer(new Node(next[0], minDistance[next[0]]));
                }
            }
        }
        
        return minDistance;
    }
}

// 풀이 1
// 1 → N으로 최단거리로 이동
// 단, 반드시 거쳐야하는 두 정점 v, w가 주어짐
// 이미 지나온 정점이나 간선을 다시 지나도 상관없으므로
// 1 → v 또는 w, v 또는 w → w 또는 v, v 또는 w → N 으로 이동하는 것을 각각 독립적으로 생각할 수 있음
// 1 → N까지 v, w를 거쳐서 가능 방법은 1 → v → w → N / 1 → w → v → N 2가지 경우가 있으므로
// 1, v, w에서 출발하여 각 정점으로 가는 최단거리 3개를 모두 구하고
// 각 이동 시마다 최단거리로 이동한 결과 두 경로 중 더 짧은 거리를 출력하면 됨