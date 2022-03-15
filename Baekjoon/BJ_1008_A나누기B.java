/**
 * BJ 1008 A/B
 * @ prob : https://www.acmicpc.net/problem/1008
 * @ level : B4
 */

import java.io.IOException;

public class BJ_1008_A나누기B {
    public static void main(String[] args) throws IOException {
        int a = System.in.read() - '0';
        System.in.read();
        int b = System.in.read() - '0';

        System.out.println((double)a / b);
    }
}
