/**
 * JO 2577 회전 초밥
 * @ prob : https://bit.ly/37jVF78
 * @ level : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2577_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());   // 회전벨트 위의 접시 수
        int D = Integer.parseInt(st.nextToken());   // 초밥 가짓수
        int K = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        int C = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] conveyer = new int[N];    // 회전벨트
        for(int i = 0; i < N; i++) {
            conveyer[i] = Integer.parseInt(br.readLine());
        }

        int[] types = new int[D+1];     // 초밥 종류별 먹은 개수
        int typeCount = 0;  // 먹는 초밥 가짓수

        // 쿠폰 초밥 먹기
        types[C]++;
        typeCount++;

        // 초기화 - 회전벨트의 0 ~ K-1 번째 초밥 먹기
        for(int i = 0; i < K; i++) {
            types[conveyer[i]]++;
            if(types[conveyer[i]] == 1) {
                typeCount++;
            }
        }

        int max = typeCount;

        // 슬라이딩 윈도우 - 회전벨트의 모든 각 위치를 시작점으로 하여 체크
        for(int i = 0; i < N-1; i++) {
            // 첫번째 빼기
            int out = i % N;
            types[conveyer[out]]--;
            if(types[conveyer[out]] == 0) {
                typeCount--;
            }
            // 마지막 다음 차례 넣기
            int in = (i + K) % N;
            types[conveyer[in]]++;
            if(types[conveyer[in]] == 1) {
                typeCount++;
            }
            
            if(max < typeCount) {
                max = typeCount;
            }
        }

        System.out.println(max);
        
        br.close();
    }
}

// 풀이 1
// Queue & HashSet 이용하여 시도
// Queue를 이용해 움직이는 회전벨트 구현
// poll() 해서 offer() 하면 맨 앞의 원소가 맨 뒤로 이동
// 그러나 Queue 내의 값이나 순서를 바꾸지 않고 0번째부터 K개를 가져오는 것이 번거로워서 진행 X

// 풀이 2
// 배열 & HashSet 이용하여 시도
// Queue 대신 기본 배열과 % 을 이용해 움직이는 회전벨트 구현
// 연속된 K개를 HashSet에 넣어서 HashSet의 size로 종류 개수 구하기
// 그러나 모든 시작점 별로 연속된 K개를 넣는 경우의 시간 복잡도가 N * K = 300만 * 3000 으로 시간초과 발생

// 풀이 3
// 배열 & 슬라이딩 윈도우 이용
// 초밥 번호를 index로 하는 초밥 종류별 개수 배열 생성
// 슬라이딩 윈도우를 이용해 K개를 다 넣는게 아니라 처음 것 빼기, 다음 것 넣기로 2번만 연산