/**
 * @ BJ 5523 경기 결과
 * @ prob : https://www.acmicpc.net/problem/5523
 */

import java.util.Scanner;
import java.io.*;

public class BJ_5523_경기결과 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] victoryCount = new int[2];

        // int n = sc.nextInt();
        int n = Integer.valueOf(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.valueOf(inputs[0]);
            int b = Integer.valueOf(inputs[1]);
            // int a = sc.nextInt();
            // int b = sc.nextInt();
            if(a > b) {
                victoryCount[0]++;
            } else if(a < b) {
                victoryCount[1]++;
            }
        }
        System.out.println(victoryCount[0] + " " + victoryCount[1]);

        br.close();
        // sc.close();
    }
}