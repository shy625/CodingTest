/**
 * 이코테 12-1 럭키 스트레이트
 * @ prob : https://www.acmicpc.net/problem/18406
 * @ level : B2
 */

import java.io.*;

public class 이코테_12_1_럭키스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < N.length() / 2; i++) {
            leftSum += N.charAt(i) - '0';
            rightSum += N.charAt(N.length() - i - 1) - '0';
        }

        System.out.println(leftSum == rightSum ? "LUCKY" : "READY");

        br.close();
    }
}

// 다른 풀이
// 합을 저장하는 변수를 하나로 두고
// 왼쪽 자릿수들을 +
// 오른쪽 자릿수들을 -
// 했을 때 최종 결과가 0인지 아닌지로 판단