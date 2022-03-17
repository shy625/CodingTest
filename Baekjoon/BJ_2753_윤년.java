/**
 * BJ 2753 윤년
 * @ prob : https://www.acmicpc.net/problem/2753
 * @ level : B4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2753_윤년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int result = 0;
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            result = 1;
        }
        System.out.println(result);
    }
}
