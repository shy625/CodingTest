/**
 * 이코테 11-4 만들 수 없는 금액
 * @ prob : 
 * @ level : 
 */

import java.io.*;
import java.util.*;

public class 이코테_11_4_만들수없는금액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coins);

        int target = 1;
        for (int i = 0; i < N; i++) {
            if (target < coins[i]) {
                break;
            }
            target += coins[i];
        }

        System.out.println(target);

        br.close();
    }
}

// 풀이 1
// 동전을 오름차순 정렬 후 작은 단위부터 현재 단위를 가지고 target 금액을 만들 수 있는지 확인
// 1 ~ target - 1 은 현재까지 주어진 동전으로 만들 수 있는 범위
// Ex)
// 동전이 1, 2, 5로 3개가 있는 경우
// 현재 0까지 만들 수 있음 / 동전 1 추가 / target : 1을 만들 수 있는지 확인 / 0 -> 0 ~ 1로 만들 수 있음
// 현재 1까지 만들 수 있음 / 동전 2 추가 / target : 2를 만들 수 있는지 확인 / 1 -> 1 ~ 3로 만들 수 있음
// 현재 3까지 만들 수 있음 / 동전 5 추가 / target : 4를 만들 수 있는지 확인 / 1 ~ 3 -> 1 ~ 3, 5 ~ 8 로 4는 만들 수 없음
// 4 출력