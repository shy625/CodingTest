/**
 * @ BJ 10820 문자열 분석
 * @ prob : https://www.acmicpc.net/problem/10820
 */

import java.util.Scanner;

public class BJ_10820_문자열분석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            int lowerCnt = 0, upperCnt = 0, digitCnt = 0, blankCnt = 0;
            for(int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if('a' <= ch && ch <= 'z') {
                    lowerCnt++;
                } else if('A' <= ch && ch <= 'Z') {
                    upperCnt++;
                } else if('0' <= ch & ch <= '9') {
                    digitCnt++;
                } else {
                    blankCnt++;
                }
            }
            System.out.println(lowerCnt + " " + upperCnt + " " + digitCnt + " " + blankCnt);
        }

        sc.close();
    }
}