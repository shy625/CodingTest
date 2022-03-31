/**
 * BJ 10989 수 정렬하기 3
 * @ prob : https://www.acmicpc.net/problem/10989
 * @ level : S5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 풀이 1
        int[] arr = new int[10001];
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr[i]; j++) {
                sb.append(i).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());


        // 풀이 2
        // int N = Integer.parseInt(br.readLine());
        // int[] arr = new int[N];
        // for(int i = 0; i < N; i++) {
        //     arr[i] = Integer.parseInt(br.readLine());
        // }

        // Arrays.sort(arr);

        // StringBuilder sb = new StringBuilder();
        // for(int i = 0; i < N; i++) {
        //     sb.append(arr[i]).append(System.lineSeparator());
        // }
        // System.out.println(sb.toString());
        
        br.close();
    }
}

// 풀이 1
// 값의 범위를 크기로 가지는 배열을 생성하고, 값을 index로 하여 해당 index 값 +1
// 출력 시 배열의 앞에서부터 차례대로 출력
// 1764ms

// 풀이 2
// 입력을 배열에 넣고 Arrays.sort()를 이용해 정렬
// 2576ms