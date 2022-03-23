/**
 * BJ 1259 팰린드롬수
 * @ prob : https://www.acmicpc.net/problem/1259
 * @ level : B1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String num = br.readLine();
            if(num.equals("0")) {
                break;
            }
            String result = "yes";
            for(int i = 0; i < num.length() / 2; i++) {
                if(num.charAt(i) != num.charAt(num.length()-1-i)) {
                    result = "no";
                    break;
                }
            }
            sb.append(result).append(System.lineSeparator());
        }

        System.out.println(sb.toString());

        br.close();
    }
}
