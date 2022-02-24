/**
 * JO 1681 해밀턴 순환회로
 * @ prob : https://bit.ly/3vdyvcq
 * @ level : 
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {

    static int N;
    static int[][] adjMatrix;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine().trim());
        adjMatrix = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for(int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        perm(0, new boolean[N], 0, 0);

        System.out.println(min);

        br.close();
    }
    
    // 장소들의 순열
    private static void perm(int count, boolean[] isVisited, int prev, int sum) {
        if(sum >= min) {    // prunning : 지금까지의 비용 합이 이미 최솟값 이상인 경우 더 이상 진행 X
            return;
        }
        if(count == N-1) {      // Base Condition : 전체 장소 N개 중 회사를 제외한 나머지 N-1개 장소에 대해 순열 완료
            if(adjMatrix[prev][0] != 0) {   // 마지막으올 선택된 장소에서 회사로 가는 길이 있으면 최솟값 계산, 없으면 무시
                min = Math.min(min, sum + adjMatrix[prev][0]);
            }
            return;
        }
        for(int i = 1; i < N; i++) {    // 시작과 끝은 회사로 고정 -> 회사를 제외한 나머지 N-1개의 순열
            if(isVisited[i] || adjMatrix[prev][i] == 0) {   // 방문한 적이 있거나 이전 위치에서 선택된 위치로 가는 길이 없는 경우 skip
                continue;
            }
            isVisited[i] = true;
            perm(count + 1, isVisited, i, sum + adjMatrix[prev][i]);    // 지금까지의 비용 + 이전 장소에서 새로 선택된 장소로 가는 비용
            isVisited[i] = false;
        }
    }
}