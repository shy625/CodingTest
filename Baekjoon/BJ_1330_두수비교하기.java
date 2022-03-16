/**
 * BJ 1330 두 수 비교하기
 * @ prob : https://www.acmicpc.net/problem/1330
 * @ level : B4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1330_두수비교하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int result = Integer.parseInt(inputs[0]) - Integer.parseInt(inputs[1]);
        System.out.println(result > 0 ? ">" : (result == 0 ? "==" : "<"));
    }
}
