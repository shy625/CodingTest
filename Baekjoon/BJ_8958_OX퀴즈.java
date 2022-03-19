/**
 * BJ 8958 OX퀴즈
 * @ prob : https://www.acmicpc.net/problem/8958
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958_OX퀴즈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            String quizResult = br.readLine();
            int score = 0;
            int total = 0;
            for(int i = 0; i < quizResult.length(); i++) {
                if(quizResult.charAt(i) == 'O') {
                    total += ++score;
                } else {
                    score = 0;
                }
            }
            sb.append(total).append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
