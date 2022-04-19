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
        String str = br.readLine();

        // 문자열 P 생성
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append("IO");
        }
        sb.append("I");
        String p = sb.toString();

        int count = 0;
        int idx = 0;
        while(idx + p.length() <= M) {
            idx = str.indexOf(p, idx);  // 문자열 S의 idx부터 문자열 P 찾기
            if(idx < 0) {   // 없으면 종료
                break;
            }
            count++;
            while(idx + p.length() + 1 < M) {   // 찾은 위치에서부터 이동하면서 확인
                if(!nextIOCheck(str, p, idx)) {     // P가 안되면 종료
                    break;
                }
                count++;
                idx += 2;   // 2칸 이동
            }
            idx += p.length();  // 문자열 길이만큼 idx 이동
        }

        System.out.println(count);

        br.close();
    }

    // 찾은 문자열 마지막의 다음, 다다음 문자 확인
    private static boolean nextIOCheck(String str, String p, int idx) {
        return str.charAt(idx + p.length()) == 'O'
                && str.charAt(idx + p.length() + 1) == 'I';
    }
}

// 풀이 1 - 시간초과
// 주어진 N에 따라 문자열 P 생성
// 생성한 문자열 P를 입력으로 주어진 문자열 S에서 indexOf()를 이용해 찾음
// indexOf()를 이용해 찾은 위치에서부터 오른쪽으로 2개씩 움직이면서 확인 (슬라이딩 윈도우)
// https://www.acmicpc.net/source/42195823