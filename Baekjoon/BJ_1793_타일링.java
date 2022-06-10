/**
 * BJ 1793 타일링
 * @ prob : https://www.acmicpc.net/problem/1793
 * @ level : S2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class BJ_1793_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> inputList = new ArrayList<>();
        int max = 0;
        
        // 입력 개수가 정해지지 않은 경우 처리
        // 방법 1
        while (true) {
            String inputStr = br.readLine();
            if (inputStr == null || inputStr.equals("")) {
                break;
            }
            int n = Integer.parseInt(inputStr);
            inputList.add(n);
            max = Math.max(max, n);
        }

        // 방법 2
        // while (true) {
        //     try {
        //         String inputStr = br.readLine();
        //         int n = Integer.parseInt(inputStr);
        //         inputList.add(n);
        //         max = Math.max(max, n);
        //     } catch (Exception e) {
        //         break;
        //     }
        // }

        // 방법 3
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextInt()) {
        //     int n = sc.nextInt();
        //     inputList.add(n);
        //     max = Math.max(max, n);
        // }

        BigInteger[] dp = new BigInteger[max + 1];
        dp[0] = BigInteger.ONE;
        if (max > 0) {
            dp[1] = BigInteger.ONE;
            for (int i = 2; i < dp.length; i++) {
                dp[i] = dp[i - 1].add(dp[i - 1]);
                if (i % 2 == 0) {
                    dp[i] = dp[i].add(BigInteger.ONE);
                } else {
                    dp[i] = dp[i].subtract(BigInteger.ONE);
                }
            }
        }

        for (int i : inputList) {
            sb.append(dp[i].toString()).append(System.lineSeparator());
        }

        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// DP 사용
// dp[i] : 2xi 직사각형을 2x1, 2x2 타일로 채우는 방법의 수 저장
// 1. dp[i] = 2 * dp[i - 1] + 1 (i가 짝수인 경우)
// 2. dp[i] = 2 * dp[i - 1] - 1 (i가 홀수인 경우)
// 단, 정답의 범위가 int, long을 넘어가기 때문에 BigInteger 사용
// 추가로 입력의 개수가 정해지지 않았기 때문에 그에 대한 처리 필요

// 다른 풀이 1
// dp[i] = dp[i - 1] + 2 * dp[i - 2]