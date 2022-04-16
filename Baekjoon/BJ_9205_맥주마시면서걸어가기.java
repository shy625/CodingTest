/**
 * BJ 9205 맥주 마시면서 걸어가기
 * @ prob : https://www.acmicpc.net/problem/9205
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기 {

    static int[][] pos;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            pos = new int[N+2][2];

            for(int i = 0; i < pos.length; i++) {
                st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }

            isVisited = new boolean[pos.length];

            sb.append(dfs(0) ? "happy" : "sad").append(System.lineSeparator());
            // sb.append(bfs(0) ? "happy" : "sad").append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

	public static boolean dfs(int cur) {
		if(cur == pos.length - 1) {
            return true;
        }
        isVisited[cur] = true;
		for(int i = 0; i < pos.length; i++) {
			if(!isVisited[i] && canGo(pos[cur], pos[i])) {
				isVisited[i] = true;
				if(dfs(i)) {
                    return true;
                }
			}
		}
		return false;
	}

    // private static boolean bfs(int start) {
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean[] isVisited = new boolean[pos.length];
    //
    //     isVisited[start] = true;
    //     q.offer(start);
    //     while(!q.isEmpty()) {
    //         int cur = q.poll();
    //         if(cur == pos.length - 1) {
    //             return true;
    //         }
    //         for(int i = 0; i < pos.length; i++) {
    //             if(!isVisited[i] && canGo(pos[cur], pos[i])) {
    //                 isVisited[i] = true;
    //                 q.offer(i);
    //             }
    //         }
    //     }
    //     return false;
    // }

    private static boolean canGo(int[] from, int[] to) {
        int xDiff = Math.abs(from[0] - to[0]);
        int yDiff = Math.abs(from[1] - to[1]);
        return xDiff + yDiff <= 1000 ? true : false;
    }
}

// 풀이 1
// 맥주 1병 -> 50m, 맥주 20병 -> 1000m, 따라서 한번에 최대로 갈 수 있는 거리는 1000m
// 출발, 도착, 편의점 위치 초기화 후 현재 위치에서 맨해튼 거리로 1000m 이내에 있는 위치에 대해 간선 연결 -> 인접리스트 생성
// 만든 인접리스트에 대해 BFS 진행 -> 도착점에 갈 수 있는지 여부 체크
// https://www.acmicpc.net/source/42072389

// 풀이 2
// 인접리스트 따로 생성하지 않고 입력 시 초기화한 출발, 도착, 편의점 위치 배열을 BFS 시 그대로 사용
// 현재 위치에서 맨해튼 거리를 계산해서 1000m 이하이면 Queue에 삽입
// https://www.acmicpc.net/source/42073424

// 풀이 3
// 풀이 2와 동일한 상태에서 BFS 대신 DFS 사용
// https://www.acmicpc.net/source/42073463