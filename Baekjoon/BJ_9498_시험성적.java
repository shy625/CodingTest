/**
 * BJ 9498 시험 성적
 * @ prob : https://www.acmicpc.net/problem/9498
 * @ level : B4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9498_시험성적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());
        char result = ' ';

        if(score >= 90) {
            result = 'A';
        } else if(score >= 80) {
            result = 'B';
        } else if(score >= 70) {
            result = 'C';
        } else if(score >= 60) {
            result = 'D';
        } else {
            result = 'F';
        }

        System.out.println(result);
    }
}

// 풀이 1
// if-else 이용

// 풀이 2
// switch 이용

// switch(score / 10) {
//     case 10 :
//     case 9 :
//         result = 'A';
//         break;
//     case 8 :
//         result = 'B';
//         break;
//     case 7 :
//         result = 'C';
//         break;
//     case 6 :
//         result = 'D';
//         break;
//     default :
//         result = 'F';
//         break;
// }