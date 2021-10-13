/**
 * @ BJ 5586 JOI와 IOI
 * @ prob : https://www.acmicpc.net/problem/5586
 */

import java.util.Scanner;

public class BJ_5586_JOI와IOI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int JOICount = 0, IOICount = 0;
        int pos = 0;
        // while(pos <= (input.length() - 3)) {    // substring()에서 Exception 발생하지 않도록 pos 값 제한
        while(pos < input.length()) {
            try {   // try-catch 문으로 Exception 발생 시 반복 종료 -> pos 값 제한 없이 문자열 길이 끝까지 반복 진행 가능
                if(input.substring(pos, pos + 3).equals("JOI")) {   // substring() 에서 endIndex가 문자열의 길이를 넘으면 IndexOutOfBoundsException 발생
                    pos += 3;
                    JOICount++;
                } else {
                    pos++;
                }
            } catch(Exception e) {
                break;
            }
        }
        System.out.println(JOICount);

        pos = 0;
        // while(pos <= (input.length() - 3)) {
        while(pos < input.length()) {
            try {
                if(input.substring(pos, pos + 3).equals("IOI")) {
                    pos += 2;
                    IOICount++;
                } else {
                    pos++;
                }
            } catch(Exception e) {
                break;
            }
        }
        System.out.println(IOICount);

        sc.close();
    }
}

// 다른 풀이 1
// index를 1씩 증가하면서 index ~ index+2 의 값을 모두 확인
// https://www.acmicpc.net/source/13501789

