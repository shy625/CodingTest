/**
 * @ BJ 5524 입실 관리
 * @ prob : https://www.acmicpc.net/problem/5524
 */

import java.io.*;

public class BJ_5524_입실관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(br.readLine());
        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            sb.append(name.toLowerCase()).append("\n");
        }
        System.out.println(sb);

        br.close();
    }
}