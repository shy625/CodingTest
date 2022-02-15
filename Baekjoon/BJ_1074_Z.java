/**
 * BJ 1074 Z
 * @ prob : https://www.acmicpc.net/problem/1074
 * @ level : S1
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074_Z {

    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        R = Integer.parseInt(inputs[1]);
        C = Integer.parseInt(inputs[2]);

        int arrLength = (int)Math.pow(2, N);

        markingZ(0, 0, arrLength, 0);

        br.close();
    }

    private static void markingZ(int r, int c, int length, int num) {
        if(r == R && c == C) {      // 타켓 위치면 num 출력
            System.out.println(num);
            return;
        }

        int hLength = length / 2;
        int size = hLength * hLength;
        
        // 타켓 위치가 포함된 영역 찾기
        if(r <= R && R < r + hLength) {     // 왼쪽
            if(c <= C && C < c + hLength) {     // 위
                markingZ(r, c, hLength, num);
            } else {    // 아래
                markingZ(r, c + hLength, hLength, num + size * 1);
            }
        } else {        // 오른쪽
            if(c <= C && C < c + hLength) {     // 위
                markingZ(r + hLength, c, hLength, num + size * 2);
            } else {    // 아래
                markingZ(r + hLength, c + hLength, hLength, num + size * 3);
            }
        }
    }
}