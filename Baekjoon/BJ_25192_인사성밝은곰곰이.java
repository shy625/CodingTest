/**
 * BJ 25192 인사성 밝은 곰곰이
 * @ prob : https://www.acmicpc.net/problem/25192
 * @ level : S4
 * 제1회 곰곰컵 B번
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int emoCnt = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                emoCnt += set.size();
                set.clear();
            } else {
                set.add(input);
            }
        }
        emoCnt += set.size();

        System.out.println(emoCnt);

        br.close();
    }
}

// 풀이 1
// Set 이용
// "ENTER" 이후에 나오는 유저의 닉네임을 Set에 저장하여 중복 제거
// 다음 "ENTER"가 나오면 그때까지의 Set의 크기를 출력하고 Set 비우기