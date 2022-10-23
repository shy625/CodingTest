import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v = wires[i][0] - 1;
            int w = wires[i][1] - 1;
            adjList[v].add(w);
            adjList[w].add(v);
        }
        
        int minGap = n;
        for (int i = 0; i < wires.length; i++) {
            // n이 짝수일 때 차가 0 또는 n이 홀수일 때 차가 1이면 더 이상 진행할 필요 X
            // 주어지는 n 개수 자체가 작아서 속도에 큰 영향 X, 오히려 연산 추가로 느려질 수 있음
            // if (((n & 1) == 0 && minGap == 0) || ((n & 1) == 1 && minGap == 1)) {
            //     break;
            // }
            int v = wires[i][0] - 1;
            int w = wires[i][1] - 1;
            adjList[v].remove(Integer.valueOf(w));
            adjList[w].remove(Integer.valueOf(v));
            // int tree1 = countTreeNode(adjList, v, new boolean[n]);
            // int tree2 = n - tree1;
            // int gap = Math.abs(tree1 - tree2);
            int gap = Math.abs(n - 2 * countTreeNode(adjList, v, new boolean[n]));
            minGap = Math.min(minGap, gap);
            adjList[v].add(w);
            adjList[w].add(v);
        }

        return minGap;
    }
    
    private int countTreeNode(List<Integer>[] adjList, int start, boolean[] isVisited) {
        int count = 1;
        isVisited[start] = true;
        for (int n : adjList[start]) {
            if (!isVisited[n]) {
                count += countTreeNode(adjList, n, isVisited);
            }
        }
        return count;
    }
}

// 풀이 1
// 송전탑 n개 2~100
// 트리 형태이므로 edge 최대 n-1개
// 주어지는 n의 크기 작으므로 완전탐색 풀이 가능
// 주어진 값에 따라 그래프(트리)를 만들고 edge를 하나씩 끊고 분리된 트리의 노드 개수를 dfs(또는 bfs)로 계산
// 가장 작은 차이 값을 반환

// 다른 풀이 1
// 트리 특성 상 각 노드는 자신의 부모와만 연결
// 트리 중 a ← b (a가 부모, b가 자식)로 연결되어 있을 때,
// 해당 연결을 끊게 되면 분리된 트리의 노드 개수는 b를 포함한 자식 노드의 개수
// 따라서 연결선을 for 돌면서 하나를 자르고 분리된 트리의 노드 개수를 구할 필요없이
// root부터 dfs를 돌면서 각 자식 트리의 노드 개수와 나머지 노드의 개수의 차를 구하면 됨