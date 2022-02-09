/**
 * SWEA 7234 안전 기지
 * @ prob : https://bit.ly/3B69IYI
 * @ level : D3
 * @ blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7234_안전기지 {

    static int N, B;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());     // 테스트 케이스 개수 입력 뒤 공백 제거
        for(int t = 1; t <= T; t++){
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            map = new int[N+1][N+1];    // 좌표가 1 ~ N
            int max = -1;
            // 안전기지의 위치를 받으면서 기지가 커버하는 영역 체크
            for(int i = 0; i < B; i++) {
                String[] base = br.readLine().split(" ");
                int r = Integer.parseInt(base[0]);
                int c = Integer.parseInt(base[1]);

                max = Math.max(max, ++map[r][c]);   // 안전기지 위치 +1 및 max 확인

                // 4방 탐색
                for(int j = 0; j < 4; j++) {
                    int nr = r;
                    int nc = c;
                    // 각 방향으로 2칸씩 커버
                    for(int k = 0; k < 2; k++) {
                        nr += dr[j];
                        nc += dc[j];
                        // 지도 밖으로 나가면 break
                        if(nr < 1 || N < nr || nc < 1 || N < nc) {
                            break;
                        }
                        max = Math.max(max, ++map[nr][nc]);     // 안전기지가 커버하면 +1 및 max 확인
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }

        br.close();
    }
}