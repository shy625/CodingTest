/**
 * BJ 2775 부녀회장이 될테야
 * @ prob : https://www.acmicpc.net/problem/2775
 * @ level : B1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2775_부녀회장이될테야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] apartment = new int[15][15];
        for(int i = 0; i < 15; i++) {
            apartment[0][i] = i;
        }
        for(int k = 1; k < 15; k++) {
            for(int n = 1; n < 15; n++) {
                for(int i = 1; i <= n; i++) {
                    apartment[k][n] += apartment[k-1][i];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            sb.append(apartment[K][N]).append(System.lineSeparator());
            // sb.append(getLivePeople(K, N)).append(System.lineSeparator());
        }

        System.out.println(sb.toString());

        br.close();
    }

    // private static int getLivePeople(int k, int n) {
    //     if(k == 0) {
    //         return n;
    //     }
    //     int sum = 0;
    //     for(int i = 1; i <= n; i++) {
    //         sum += getLivePeople(k-1, i);
    //     }
    //     return sum;
    // }
}

// 풀이 1
// K, N의 최대값이 정해져 있으므로 아파트 각 호의 사람 수를 미리 계산. 이후 주어진 k, n으로 값을 바로 찾아서 출력
// 120ms

// 풀이 2
// 재귀를 이용해 주어진 k, n에 해당하는 아파트 호의 사람 수를 그때 그때 계산
// 420ms