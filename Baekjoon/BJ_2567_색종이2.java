/**
 * BJ 2567 색종이2
 * @ prob : https://www.acmicpc.net/problem/2567
 * @ level : S4
 * @ blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] white = new int[101][101];      // 마지막 한 줄을 추가해서 검은 색종이가 도화지의 끝 부분에 닿게 붙어있는 경우도 확인

        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x+10; i++) {
                for(int j = y; j < y+10; j++) {
                    white[i][j] = 1;
                }
            }
        }

        int length = 0;     // 둘레 길이

        int rowPrev = 0, colPrev = 0;   // 이전 좌표의 값
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                // 세로변 길이 체크
                if(white[i][j] != rowPrev) {    // 이전 값과 현재 값이 다르면 == 경계
                    length++;
                    rowPrev = white[i][j];      // 다음 체크를 위한 값 업데이트
                }
                // 가로변 길이 체크
                if(white[j][i] != colPrev) {    // 이전 값과 현재 값이 다르면 == 경계
                    length++;
                    colPrev = white[j][i];      // 다음 체크를 위한 값 업데이트
                }
            }
        }

        System.out.println(length);

        br.close();
    }
}

// 풀이
// 좌에서 우, 위에서 아래로 한줄씩 확인하면서 값이 달라지는 부분(=경계)일 때 +1
// 위의 풀이

// 다른 풀이 1
// 전체 좌표를 돌아다니면서 흰색 또는 검은색일 때 주위 4방향의 좌표를 확인하여 다른 색이 있다면 +1
// https://www.acmicpc.net/source/5584708
// https://www.acmicpc.net/source/17431093