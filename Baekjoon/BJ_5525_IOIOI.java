/**
 * BJ 5525 IOIOI
 * @ prob : https://www.acmicpc.net/problem/5525
 * @ level : S1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BJ_5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
    
        int p = 0;
        int count = 0;
        int idx = 0;
        while(idx < M-2) {
            if(S.charAt(idx) == 'I' && S.charAt(idx+1) == 'O' && S.charAt(idx+2) == 'I') {  // 패턴 O
                p++;
                idx += 2;   // 패턴으로 확인한 부분 다음부터 진행
            } else {    // 패턴 X
                p = 0;
                idx++;
            }
            if(p == N) {    // 문자열 P 성립
                count++;
                p--;    // 이후에도 이어질 수 있기 때문에 0이 아닌 맨 앞 패턴만 제거
            }
        }
        System.out.println(count);

        br.close();
    }
}

// 풀이 1 - 시간초과
// 주어진 N에 따라 문자열 P 생성
// 생성한 문자열 P를 입력으로 주어진 문자열 S에서 indexOf()를 이용해 찾음
// indexOf()를 이용해 찾은 위치에서부터 오른쪽으로 2개씩 움직이면서 확인 (슬라이딩 윈도우)
// https://www.acmicpc.net/source/42195823

// 풀이 2 - 시간초과
// 풀이 1과 비슷하나 N에 따라 문자열 P를 생성하지 않고 바로 진행
// https://www.acmicpc.net/source/42398706

// 풀이 3
// 주어진 문자열 S에 대해 IOI 패턴의 개수를 체크
// 패턴의 개수가 N이 되면 개수 증가, 패턴 개수 -1
// 패턴이 아니면 패턴 개수 0
// https://velog.io/@woga1999/BOJ-5525%EB%B2%88-IOIOI-Python
// https://donggoolosori.github.io/2020/09/27/boj-5525/