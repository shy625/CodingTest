/**
 * 이코테 3-3 숫자 카드 게임
 * @ prob : 
 * @ level : 
 */

import java.io.*;
import java.util.*;

public class 이코테_3_3_숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int rowMin = Integer.MAX_VALUE;
            // 주어진 행 중에서 가장 작은 값 찾기
            for (int j = 0; j < M; j++) {
                rowMin = Math.min(rowMin, Integer.parseInt(st.nextToken()));
            }
            max = Math.max(max, rowMin);    // 행에서 찾은 가장 작은 값들 중 가장 큰 값 찾기
        }

        System.out.println(max);

        br.close();
    }
}
