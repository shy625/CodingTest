/**
 * BJ 2563 색종이
 * @ prob : https://www.acmicpc.net/problem/2563
 * @ level : B1
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] white = new int[100][100];

        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 검은 색종이 영역
            for(int i = x; i < x+10; i++) {
                for(int j = 99-y; j > 99-y-10; j--) {
                    white[i][j] = 1;    // 검은 색종이 영역을 1로 체크
                }
            }
        }

        int blackArea = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                blackArea += white[i][j];
            }
        }

        System.out.println(blackArea);

        br.close();
    }
}

// 다른 풀이 1
// 흰색 도화지와 검은색 색종이 모두 정사각형이기 때문에 가로, 세로 모두 대칭
// 검은 색종이의 아래쪽 거리를 위로 뒤집어서 계산해도 넓이는 동일 

// for(int i = x; i < x+10; i++) {
//     for(int j = y; j < y+10; j++) {     // 세로 방향을 뒤집어서 계산해도 ok
//         white[i][j] = 1;
//     }
// }