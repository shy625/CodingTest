/**
 * BJ 1152 단어의 개수
 * @ prob : https://www.acmicpc.net/problem/1152
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1152_단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        System.out.println(input.equals("") ? 0 : input.split(" ").length);
    }
}
 