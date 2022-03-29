/**
 * BJ 2869 달팽이는 올라가고 싶다
 * @ prob : https://www.acmicpc.net/problem/2869
 * @ level : B1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        System.out.println(1 + (int)Math.ceil((double)(V - A) / (A - B)));

        br.close();
    }
}
