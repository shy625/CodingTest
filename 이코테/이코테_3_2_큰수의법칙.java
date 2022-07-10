/**
 * 이코테 3-2 큰 수의 법칙
 * @ prob : 
 * @ level : 
 */

import java.io.*;
import java.util.*;

public class 이코테_3_2_큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[N - 1];
        int second = arr[N - 2];

        // 반복문을 이용한 풀이 - 주어지는 값이 커지면 시간초과가 날 수 있음
        // int sum = 0;
        // int seqCount = 0;
        // for (int m = 0; m < M; m++) {
        //     if (seqCount == K) {
        //         sum += arr[N - 2];
        //         seqCount = 0;
        //     } else {
        //         sum += arr[N - 1];
        //         seqCount++;
        //     }
        // }

        // 수학적 계산을 이용한 풀이 - 시간 초과 X
        int count = (M / (K + 1)) * K;
        count += M % (K + 1);

        int sum = first * count + second * (M - count);

        System.out.println(sum);

        br.close();
    }
}
