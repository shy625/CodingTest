/**
 * BJ 1620 나는야 포켓몬 마스터 이다솜
 * @ prob : https://www.acmicpc.net/problem/1620
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> numHashMap = new HashMap<>();
        HashMap<String, Integer> nameHashMap = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            numHashMap.put(i, name);
            nameHashMap.put(name, i);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int num = Integer.parseInt(input);  // 문자열을 숫자로 변환할 수 없는 경우 예외 던짐
                sb.append(numHashMap.get(num));
            } catch(NumberFormatException e) {
                sb.append(nameHashMap.get(input));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        br.close();
    }
}

// 풀이 1
// HashMap을 2개 사용
// 1. 번호를 key, 이름을 value로 사용하는 HashMap
// 2. 이름을 key, 번호를 value로 사용하는 HashMap
// 문제로 이름이 주어졌는지 번호가 주어졌는지 확인에 try-catch 사용

// 다른 풀이 1
// 이름을 key, 번호를 value로 하는 HashMap과 이름을 저장하는 배열 사용
// 문제 입력의 첫번째 문자를 확인하여 번호인지 이름인지 구분
// https://www.acmicpc.net/source/10273532