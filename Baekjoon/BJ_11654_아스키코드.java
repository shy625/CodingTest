/**
 * @ BJ 11654 아스키 코드
 * @ prob : https://www.acmicpc.net/problem/11654
 */

import java.util.Scanner;

public class BJ_11654_아스키코드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char input = sc.next().charAt(0);
        System.out.println((int)input);

        sc.close();
    }
}

// 다른 풀이 1
// read() 이용

// System.out.println(System.in.read());