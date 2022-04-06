/**
 * BJ 1676 팩토리얼 0의 개수
 * @ prob : https://www.acmicpc.net/problem/1676
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        if(N == 0) {    // 0! = 1
            result = 0;
        } else {
            int count2 = 0;
            int count5 = 0;
            for(int i = 1; i <= N; i++) {
                count2 += getDivCount(i, 2);
                count5 += getDivCount(i, 5);
            }
            result = Math.min(count2, count5);
        }

        System.out.println(result);

        br.close();
    }

    // N에 약수로 포함된 수 div의 개수
    private static int getDivCount(int N, int div) {
        int count = 0;
        while(N % div == 0) {
            count++;
            N /= div;
        }
        return count;
    }
}

// 풀이 1
// 첫 자리에 0이 나오기 위해서는 10이 곱해져야 함 -> 10은 2, 5의 곱으로 이루어짐
// 따라서 N!에 곱해지는 2와 5의 수 = 0의 개수
// 단, 2와 5가 하나씩 있어야 10 한개가 만들어지므로 둘 중 작은 것의 개수만큼 10이 생긴다.
// 따라서 N!에 들어가는 각 수에서 2와 5의 수를 구하고 둘 중 작은 것을 결과로 출력한다.

// 다른 풀이 1
// 0의 개수 = 10의 개수 = 2와 5의 개수
// 2가 5보다 크므로 N!에서 2가 5보다 더 많이 등장할 수 밖에 없음
// 따라서 5의 수가 항상 2의 수보다 적으므로 5의 수만 구하면 됨
// N / 5 : N까지 5를 약수로 가지는 수가 등장하는 횟수
// 마찬가지로 5^2, 5^3에 대해서도 개수를 구하고 (N이 500까지이므로 그 이상은 핦 필요 X) 더한 결과를 출력
// https://www.acmicpc.net/source/40615688