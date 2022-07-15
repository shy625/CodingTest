/**
 * 이코테 11-3 문자열 뒤집기
 * @ prob : https://www.acmicpc.net/problem/1439
 * @ level : S5
 */

import java.io.*;

public class 이코테_11_3_문자열뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int zeroSeqCnt = 0, oneSeqCnt = 0;

        char prev = S.charAt(0); // 초기 세팅
        // 2번째 원소부터 이전 원소와 동일한지 확인하면서 0, 1 그룹 개수 세기
        for (int i = 1; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (prev != cur) { // 이전 원소와 다른 경우
                if (prev == '0') {
                    zeroSeqCnt++;
                } else {
                    oneSeqCnt++;
                }
                prev = cur;
            }
        }
        // 마지막 원소(그룹) 체크
        if (S.charAt(S.length() - 1) == '0') {
            zeroSeqCnt++;
        } else {
            oneSeqCnt++;
        }

        System.out.println(zeroSeqCnt >= oneSeqCnt ? oneSeqCnt : zeroSeqCnt);
        // System.out.println(Math.min(zeroSeqCnt, oneSeqCnt));

        br.close();
    }
}
