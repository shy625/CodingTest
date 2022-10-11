import java.util.*;

class Solution {
    
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
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            int v = edge[i][0];
            int w = edge[i][1];
            adjList[v].add(w);
            adjList[w].add(v);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] minDistance = new int[n + 1];
        boolean[] isChecked = new boolean[n + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        pq.offer(new Node(1, 0));
        minDistance[1] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (isChecked[cur.num]) {
                continue;
            }
            
            isChecked[cur.num] = true;
            
            for (Integer next : adjList[cur.num]) {
                if (!isChecked[next] && minDistance[next] > minDistance[cur.num] + 1) {
                    minDistance[next] = minDistance[cur.num] + 1;
                    pq.offer(new Node(next, minDistance[next]));
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, minDistance[i]);
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (minDistance[i] == max) {
                count++;
            }
        }
        
        return count;
    }
}

// 풀이 1
// 1번 노드에서 가장 멀리 떨어진 노드의 개수
// 가장 멀리 떨어진 == 최단 경로로 이동 시 간선의 개수가 가장 많은 노드들
// 간선 비용 X -> 모든 간선의 비용 1
// 따라서 모든 간선의 비용이 1인 양방향 그래프에서 출발점을 1로 하여 각 노드에 대해 최단 경로 구하기
// Dijkstra 사용