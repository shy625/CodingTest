/**
 * BJ 2839 설탕 배달
 * @ prob : https://www.acmicpc.net/problem/2839
 * @ level : B1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = -1;
        for(int i = 0 ; i <= N/3; i++) {
            int remain = N - 3 * i;
            if(remain % 5 == 0) {
                count = remain / 5 + i;
                break;
            }
        }

        System.out.println(count);

        br.close();
    }
}
