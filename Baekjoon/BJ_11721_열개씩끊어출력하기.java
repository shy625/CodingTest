/**
 * @ BJ 11721 열 개씩 끊어 출력하기
 * @ prob : https://www.acmicpc.net/problem/11721
 */

import java.util.Scanner;

public class BJ_11721_열개씩끊어출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int cur = 0;

        while(input.length() > cur) {
            System.out.println(input.substring(cur, Math.min(cur+10, input.length())));
            cur += 10;
        }

        sc.close();
    }
}

// 다른 풀이 1
// 문자 10개마다 개행 출력

// char[] input = sc.nextLine().toCharArray();     // 또는 문자열로 받아서 chatAt() 사용
// for(int i = 0; i < input.length; i++) {
//     System.out.print(input[i]);
//     if(i % 10 == 9) {
//         System.out.println();
//     }
// }

// 다른 풀이 2
// 정규식의 그룹 이용
// https://www.acmicpc.net/source/2948143
// https://www.acmicpc.net/source/5996174

// 어떤 문자 10개가 오는 것을 패턴으로 하여 그룹으로 매칭
// 매칭된 그룹 -> 매칭된 그룹\n 의 형태로 모두 변경
// System.out.println(input.replaceAll("(.{10})", "$1\n"));

// 다른 풀이 3
// 나의 풀이처럼 substring() 이용, 반복 로직이 다름

// while(input.length() > 10) {
//     System.out.println(input.substring(0, 10));
//     input = input.substring(10);
// }
// System.out.println(input);