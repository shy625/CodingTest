/**
 * 이코테 11-5 볼링공 고르기
 * @ prob : 
 * @ level : 
 */

import java.io.*;
import java.util.*;

public class 이코테_11_5_볼링공고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] balls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balls[i] = Integer.parseInt(st.nextToken());
        }

        int combiCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (balls[i] != balls[j]) {
                    combiCount++;
                }
            }
        }

        System.out.println(combiCount);        

        br.close();
    }    
}

// 풀이 1
// A와 B가 서로 다른 무게의 볼링공을 고르는 조합을 구하는 문제
// A와 B가 공을 선택하는 모든 조합 중에서 서로 무게가 다른 경우만 카운트

// 다른 풀이 1
// 각 무게별 볼링공 개수를 저장
// 조합을 무게 기준으로 진행
// A가 선택한 무게의 공 수 * B가 선택한 무게의 공 수
// 더 효율적

// int[] ballWeight = new int[M + 1];
// st = new StringTokenizer(br.readLine());
// for (int i = 0; i < N; i++) {
//     int weight = Integer.parseInt(st.nextToken());
//     ballWeight[weight]++;
// }
// int count = 0;
// for (int i = 1; i <= M; i++) {
//     for (int j = i + 1; j <= M; j++) {
//         count += ballWeight[i] * ballWeight[j];
//     }
// }
// System.out.println(count);
