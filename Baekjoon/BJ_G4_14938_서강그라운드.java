import java.io.*;
import java.util.*;

public class BJ_G4_14938_서강그라운드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] regions = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            regions[i] = Integer.parseInt(st.nextToken());
        }

        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjMatrix[i], 10000);
            adjMatrix[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int l = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = l;
            adjMatrix[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
        }

        int maxItem = 0;
        for (int i = 0; i < n; i++) {
            int item = 0;
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] <= m) {
                    item += regions[j];
                }
            }
            maxItem = Math.max(maxItem, item);
        }

        System.out.println(maxItem);

        br.close();
    }
}

// 풀이 1
// 낙하지점으로부터 수색할 수 있는 범위 m 값이 주어지고
// 획득할 수 있는 최대 아이템의 개수는 각 지역의 수색 가능 여부에 따라 다름
// 따라서 각 지역을 최대한 수색 가능하게 하려면 낙하 지점으로부터 각 지역으로 최단거리로 움직여야 함
// 단, 낙하지점이 주어지지 않았고 모든 지점에 대해 낙하지점으로 가정하여 수색을 진행해봐야 하므로 모든 노드 쌍의 최단거리를 구할 수 있는 플로이드워셜 알고리즘 사용
// 플로이드워셜 알고리즘을 사용해 모든 노드 쌍에 대해 최단거리를 구하고
// 각 지역을 낙하지점으로 하고, 해당 지역에서 다른 지역으로의 최단거리가 m 이하인 지역에 있는 아이템 개수 합을 구함
// 모든 지역에 대해 완료한 뒤 그 중 최대 아이템 개수를 출력