/**
 * @ BJ 4470 줄번호
 * @ prob : https://www.acmicpc.net/problem/4470
 */

import java.io.*;

public class BJ_4470_줄번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        for(int i = 1; i <= n; i++) {
            String line = i + ". " + br.readLine() + "\n";
            bw.write(line);
        }

        bw.flush();

        br.close();
        bw.close();
    }
}