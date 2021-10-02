/**
 * @ BJ 10808 알파벳 개수
 * @ prob : https://www.acmicpc.net/problem/10808
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] alphabets = new int[26];
        String input = sc.nextLine();
        for(int i = 0; i < input.length(); i++) {
            alphabets[input.charAt(i)-'a']++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i : alphabets) {
            // System.out.print(i + " ");
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        sc.close();
    }
}