/**
 * @ BJ 11656 접미사 배열
 * @ prob : https://www.acmicpc.net/problem/11656
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11656_접미사배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] suffixes = new String[s.length()];
        for(int i = 0; i < suffixes.length; i++) {
            suffixes[i] = s.substring(i);
        }
        Arrays.sort(suffixes);
        for(String suffix : suffixes) {
            System.out.println(suffix);
        }

        sc.close();
    }
}