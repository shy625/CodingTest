/**
 * BJ 17219 비밀번호 찾기
 * @ prob : https://www.acmicpc.net/problem/17219
 * @ level : S4
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()));
            bw.write(System.lineSeparator());
        }

        bw.flush();

        br.close();
        bw.close();
    }
}

// 풀이 1
// Map 사용 (HashMap)
// key - 사이트 주소, value - 비밀번호