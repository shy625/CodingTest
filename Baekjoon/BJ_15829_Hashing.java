/**
 * BJ 15829 Hashing
 * @ prob : https://www.acmicpc.net/problem/15829
 * @ level : B2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long sum = 0;
        for(int i = 0; i < L; i++) {
            long val = input.charAt(i) - 96;
            for(int j = 0; j < i; j++) {
                val *= 31;
                val %= 1234567891;
            }
            sum += val;
            sum %= 1234567891;
        }
        System.out.println(sum);

        br.close();
    }
}
