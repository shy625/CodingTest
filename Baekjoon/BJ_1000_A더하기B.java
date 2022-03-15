/**
 * BJ 1000 A+B
 * @ prob : https://www.acmicpc.net/problem/1000
 * @ level : B5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1000_A더하기B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
    }
}