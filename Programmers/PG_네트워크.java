/**
 * PG 네트워크
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/43162
 * @ level : 3
 */

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int networkCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                networkCount++;
                dfs(i, computers, isVisited);
            }
        }
        
        return networkCount;
    }
    
    private void dfs(int start, int[][] computers, boolean[] isVisited) {
        isVisited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!isVisited[i] && computers[start][i] == 1) {
                dfs(i, computers, isVisited);
            }
        }
    }
}

// 풀이 1
// 전체 컴퓨터에 대해 반복을 돌면서 방문처리가 안되어 있는 정점을 시작으로 DFS 진행
// DFS를 한번 시작할 때마다 네트워크 개수 +1
// DFS를 이용하여 하나로 연결되어 있는 네트워크의 정점들을 탐색하면서 방문 처리
