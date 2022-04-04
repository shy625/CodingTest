/**
 * SWEA 3307 최장 증가 부분 수열
 * @ prob : https://bit.ly/3LIKSCx
 * @ level : D3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // dp 배열
            int[] lis = new int[N];
            lis[0] = 1;     // 첫번째 원소만 포함되었을 때 값 1로 초기화
            
            // i번째 원소를 포함시키는 경우
            for(int i = 1; i < N; i++) {
                int max = 0;
                // 0 ~ i-1번째 원소들 탐색
                for(int j = 0; j < i; j++) {
                    // i번째 원소값이 크거나 같아서 해당 수열에 다음에 포함할 수 있는 경우 max 값 확인
                    if(arr[j] <= arr[i]) {
                        max = Math.max(max, lis[j]);
                    }
                }
                lis[i] = max + 1;   // i번째 원소를 포함할 수 있는 수열 중 가장 긴 수열 + 1
            }

            int result = 0;
            // 전체 결과 중 가장 긴 것을 출력
            for(int i = 0; i < N; i++) {
                result = Math.max(result, lis[i]);
            }
            sb.append("#" + t + " " + result).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// DP 활용
// lis(i)
//     1. i = 1 -> lis(i) = 1
//     2. arr[0] ~ arr[i-1] < arr[i] 일 때, lis의 최댓값 + 1