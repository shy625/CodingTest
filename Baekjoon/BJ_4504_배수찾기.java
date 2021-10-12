/**
 * @ BJ 4504 배수 찾기
 * @ prob : https://www.acmicpc.net/problem/4504
 */

import java.util.Scanner;
import java.io.*;

public class BJ_4504_배수찾기 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // int n = sc.nextInt();
        int n = Integer.valueOf(br.readLine());

        int x = 0;
        // while((x = sc.nextInt()) != 0) {
        while((x = Integer.valueOf(br.readLine())) != 0) {
            if((x % n) == 0) {
                // System.out.println(x + " is a multiple of " + n + ".");
                sb.append(x + " is a multiple of " + n + ".\n");
            } else {
                // System.out.println(x + " is NOT a multiple of " + n + ".");
                sb.append(x + " is NOT a multiple of " + n + ".\n");
            }
        }
        System.out.print(sb.toString());

        // sc.close();
        br.close();
    }
}