/**
 * SWEA 1220 Magnetic
 * @ prob : https://bit.ly/36tGTu2
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        for(int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] table = new int[N][N];

            // table 입력 처리
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int c = 0; c < N; c++) {
                boolean isCrashable = false;    // 충돌 발생 가능 여부
                for(int r = 0; r < N; r++) {    // 세로로 체크
                    if(table[r][c] == 1) {      // 1 (아래로 향하는 자성체)를 만나면 충돌 발생 가능 여부 체크
                        isCrashable = true;
                    } else if(table[r][c] == 2 && isCrashable) {    // 2 (위로 향하는 자성체)를 만나고 이전에 1을 만났으면 충돌 발생
                        count++;
                        isCrashable = false;    // 초기화. 충돌 이후에 새로 1과 2가 나온다면 또 충돌 발생
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// String[][] table, split() 사용 : 입력을 split()으로 파싱만해서 풀이
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
// 145ms

// 풀이 2
// int[][] table, split() 사용 : 입력을 split()으로 파싱한 후, int로 변환하여 풀이
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
// 150ms

// 풀이 3
// int[][] table, StringTokenizer 사용 : 입력을 StringTokenizer로 파싱한 후, int로 변환하여 풀이
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
// 137ms

// 풀이 4
// String[][] table, StringTokenizer 사용 : 입력을 StringTokenizer로 파싱만해서 풀이
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do
// 141ms