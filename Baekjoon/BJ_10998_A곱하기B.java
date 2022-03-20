/**
 * BJ 10998 AxB
 * @ prob : https://www.acmicpc.net/problem/10998
 * @ level : B5
 */

import java.io.IOException;

public class BJ_10998_A곱하기B {
    public static void main(String[] args) throws IOException {
        int a = System.in.read() - '0';
        System.in.read();
        int b = System.in.read() - '0';

        System.out.println(a * b);
    }
}
