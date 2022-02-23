/**
 * SWEA 7964 부먹왕국의 차원 관문
 * @ prob : https://bit.ly/3t48ZDI
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7964_부먹왕국의차원관문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int D = Integer.parseInt(inputs[1]);

            String[] map = br.readLine().split(" ");

            int sum = 0;
            int zeroCount = 0;
            for(int i = 0; i < N; i++) {
                if(map[i].equals("0")) {
                    zeroCount++;    // 연속해서 0이 나오는 구간의 길이 구하기
                } else {
                    sum += zeroCount / D;   // 0이 연속한 구간에 (0의 개수 / 이동 제한 거리) 만큼의 차원관문 설치
                    zeroCount = 0;      // 1이 나왔으니 연속 구간 초기화
                }
            }
            sum += zeroCount / D;   // 마지막에 1이 나오지 않고 0으로 끝나는 경우를 위해 한번 더 계산 추가

            sb.append("#" + t + " " + sum).append('\n');
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 다른 풀이 1
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do