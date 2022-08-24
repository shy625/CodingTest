/**
 * BJ 1022 소용돌이 예쁘게 출력하기
 * @ prob : https://www.acmicpc.net/problem/1022
 * @ level : G4
 */

import java.io.*;
import java.util.*;

public class BJ_1022_소용돌이예쁘게출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int maxDist = Math.max(Math.abs(r1), Math.max(Math.abs(c1), Math.max(Math.abs(r2), Math.abs(c2))));
        int size = maxDist * 2 + 1;
        int[][] square = new int[size][size];
        int count = 1;
        square[maxDist][maxDist] = count++;
        for (int dist = 1; dist <= maxDist; dist++) {
            for (int i = -dist + 1; i <= dist; i++) {
                square[maxDist - i][maxDist + dist] = count++;
            }
            for (int i = -dist + 1; i <= dist; i++) {
                square[maxDist - dist][maxDist - i] = count++;
            }
            for (int i = -dist + 1; i <= dist; i++) {
                square[maxDist + i][maxDist - dist] = count++;
            }
            for (int i = -dist + 1; i <= dist; i++) {
                square[maxDist + dist][maxDist + i] = count++;
            }
        }

        count--;
        int maxDigitCount = (int) Math.log10(count) + 1;
        StringBuilder sb = new StringBuilder();
        for (int r = r1 + maxDist; r <= r2 + maxDist; r++) {
            for (int c = c1 + maxDist; c <= c2 + maxDist; c++) {
                int digitCount = (int) Math.log10(square[r][c]) + 1;
                if (digitCount < maxDigitCount) {
                    for (int i = 0; i < maxDigitCount - digitCount; i++) {
                        sb.append(" ");
                    }
                }
                sb.append(square[r][c] + " ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.print(sb.toString());

        br.close();
    }
}

// 풀이 1 - 메모리 초과
// 주어지는 꼭짓점 2개 입력 받기
// 주어진 두 점의 좌표값 중 소용돌이의 중심으로부터 가장 먼 값 체크
// 해당 값 * 2 + 1을 한 변의 길이로 하는 정사각형 모양의 소용돌이 생성
// 처리의 편의성을 위해 중심에 가장 먼 값을 배열 좌표에 더해 소용돌이의 왼쪽 상단이 (0,0) 이 되도록 조정
// 생성한 정사각형 모양의 소용돌이에서 주어진 두 꼭짓점에 해당하는 범위를 조건에 맞게 출력
// 출력 시 값의 자릿수를 체크해 가장 값의 자릿수보다 작으면 공백 추가
// 처음에 주어지는 꼭짓점 좌표 중 하나라도 5000이라는 수가 들어오면
// 결국 한 변의 길이가 10001인 정사각형 모양의 소용돌이를 그려야 함
// 10001 * 10001 * 4B > 128MB 이기 때문에 메모리 초과 발생