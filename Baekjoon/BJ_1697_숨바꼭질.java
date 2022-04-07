/**
 * BJ 1697 숨바꼭질
 * @ prob : https://www.acmicpc.net/problem/1697
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697_숨바꼭질 {

    static final int MAX = 100000;

    static int[] move = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));

        br.close();
    }

    private static int bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();    // 점 위치, 현재 위치까지 오는데 걸린 시간
        boolean[] isVisited = new boolean[MAX+1];

        q.offer(new int[] {N, 0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curPos = cur[0];
            int curTime = cur[1];

            // 도착 시 종료, 현재 위치까지 걸린 시간 반환
            if(curPos == K) {
                return curTime;
            }

            // 다음 위치로 이동
            for(int i = 0; i < 3; i++) {
                int nextPos = curPos;
                if(i == 2) {
                    nextPos *= move[i];
                } else {
                    nextPos += move[i];
                }
                if(0 <= nextPos && nextPos <= 100000 && !isVisited[nextPos]) {
                    isVisited[nextPos] = true;
                    // 이동 시 1초 소요 : 다음 위치까지 걸리는 시간 = 현재 위치까지 걸린 시간 + 1
                    q.offer(new int[] {nextPos, curTime + 1});
                }
            }
        }

        return -1;
    }
}

// 풀이 1
// BFS 이용
// 좌표 상의 각 위치를 정점, 각 위치에서 아동할 수 있는 3가지 방법을 간선으로 설정
// 각 간선의 가중치는 1
// N에서 출발하여 K까지 가는 가장 빠른 시간 = 최단거리 -> BFS