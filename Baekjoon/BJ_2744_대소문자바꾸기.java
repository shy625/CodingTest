/**
 * @ BJ 2744 대소문자 바꾸기
 * @ prob : https://www.acmicpc.net/problem/5576
 */

import java.util.Scanner;

public class BJ_2744_대소문자바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String output = "";

        for(int i = 0; i < input.length(); i++) {
            char tmp = input.charAt(i);
            if(65 <= tmp && tmp <= 90) {
                output += (char)(tmp + 32);
            } else if(97 <= tmp && tmp <= 122) {
                output += (char)(tmp - 32);
            }
        }
        System.out.println(output);

        sc.close();
    }
}

// 다른 풀이 1
// 비트 연산자 XOR 연산을 이용하여 +32 또는 -32 계산

// for(int i = 0; i < input.length(); i++) {
//     char tmp = input.charAt(i);
//     output += (char)(tmp ^ 32);
// }

// 다른 풀이 2
// String의 내장 함수 활용 - toUpperCase(), toLowerCase()

// for(int i = 0; i < input.length(); i++) {
//     char tmp = input.charAt(i);
//     if(65 <= tmp && tmp <= 90) {
//         output += (tmp+"").toLowerCase();
//     } else if(97 <= tmp && tmp <= 122) {
//         output += (tmp+"").toUpperCase();
//     }
// }