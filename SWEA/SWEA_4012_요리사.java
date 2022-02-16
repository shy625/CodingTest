/**
 * SWEA 4012 요리사
 * @ prob : https://bit.ly/3oUAf6p
 * @ level : 
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4012_요리사 {

    static int N;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            // 입력 처리
            N = Integer.parseInt(br.readLine());
            table = new int[N][N];
            for(int i = 0; i < N; i++) {
                String[] inputs = br.readLine().split(" ");
                for(int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(inputs[j]);
                }
            }

            // Next Permutation을 이용해 조합을 구하기 위한 준비
            int[] arr = new int[N];
            for(int i = N-1; i >= N-N/2; i--) {
                arr[i] = 1;
            }

            int[] pickedA = new int[N/2];   // A 음식 재료
            int[] pickedB = new int[N/2];   // B 음식 재료
            int gapMin = Integer.MAX_VALUE;
            do {
                int curA = 0, curB = 0;
                for(int i = 0; i < N; i++) {
                    if(arr[i] != 0) {
                        pickedA[curA++] = i;
                    } else {
                        pickedB[curB++] = i;
                    }
                }
                int gap = cook(pickedA, pickedB);   // 주어진 재료로 요리 시 음식 맛의 차이
                gapMin = Math.min(gapMin, gap);     // 음식 맛 차이의 최솟값
            } while (np(arr));  // Next Permutation

            sb.append("#" + t + " " + gapMin).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }

    // 음식 맛의 차이 구하기
    private static int cook(int[] pickedA, int[] pickedB) {
        int sumA = 0, sumB = 0;

        for(int i = 0; i < N/2; i++) {
            for(int j = i+1; j < N/2; j++) {
                int ai = pickedA[i];
                int aj = pickedA[j];
                int bi = pickedB[i];
                int bj = pickedB[j];
                sumA += table[ai][aj] + table[aj][ai];
                sumB += table[bi][bj] + table[bj][bi];
            }
        }

        return Math.abs(sumA - sumB);
    }

    // Next Permutation
    private static boolean np(int[] arr) {
        int i = N - 1;
        while(i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }
        if(i == 0) {
            return false;
        }

        int j = N - 1;
        while(arr[i-1] >= arr[j]) {
            j--;
        }

        swap(arr, i-1, j);

        int k = N - 1;
        while(i < k) {
            swap(arr, i++, k--);
        }

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

// 다른 풀이
// 음식 재료를 선택할 때 Next Permutation 외에도 재귀, 비트마스킹 등을 이용한 조합을 사용해도 된다.