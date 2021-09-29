/**
 * @ BJ 1357 뒤집힌 덧셈
 * @ prob : https://www.acmicpc.net/problem/1357
 */

import java.util.Scanner;

public class BJ_1357_뒤집힌덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(), y = sc.nextInt();
        System.out.println(rev(rev(x) + rev(y)));

        sc.close();
    }

    static int rev(int num) {
        String oriNum = num + "";
        String revNum = "";
        for(int i = oriNum.length()-1; i >= 0; i--) {
            revNum += oriNum.charAt(i);
        }
        return Integer.valueOf(revNum);
    }
}

// 다른 풀이 1
// StringBuffer 또는 StringBuilder의 reverse() 사용

// static int rev(int num) {
//     return Integer.valueOf(new StringBuilder(num+"").reverse().toString());
// }

// 다른 풀이 2
// 숫자 상태에서 뒤집기

// static int rev(int num) {
//     int revNum = 0;
//     while(num > 0) {
//         revNum *= 10;
//         revNum += num % 10;
//         num /= 10;
//     }
//     return revNum;
// }