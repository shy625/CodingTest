/**
 * @ BJ 2908 상수
 * @ prob : https://www.acmicpc.net/problem/2908
 */

import java.util.Scanner;

public class BJ_2908_상수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt();
        int revA = reverse(a), revB = reverse(b);

        System.out.println(revA > revB ? revA : revB);

        sc.close();
    }

    static int reverse(int num) {
        int rev = 0;
        int base = 10;
        for(int i = 0; i < 3; i++) {
            rev *= base;
            rev += num % base;
            num /= base;
        }
        return rev;
    }
}

// 다른 방법 1
// 문자열로 받아서 뒤집는 방법

// String s = sc.nextLine();
// String rev = "";
// for(int i = s.length()-1; i >= 0; i--) {
//     rev += s.charAt(i);
// }
// String[] revNum = rev.split(" ");
// System.out.println(revNum[0].compareTo(revNum[1]) == 1 ? revNum[0] : revNum[1]);