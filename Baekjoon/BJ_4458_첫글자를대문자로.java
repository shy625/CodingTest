/**
 * @ BJ 4458 첫 글자를 대문자로
 * @ prob : https://www.acmicpc.net/problem/4458
 */

import java.util.Scanner;

public class BJ_4458_첫글자를대문자로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            StringBuilder input = new StringBuilder(sc.nextLine());
            if('a' <= input.charAt(0) && input.charAt(0) <= 'z') {
                input.setCharAt(0, (char)(input.charAt(0) - 32));
            }
            System.out.println(input.toString());

        }

        sc.close();
    }
}

// 다른 풀이 1
// char[] 로 바꿔서 첫번째 문자를 변경

// char[] input = sc.nextLine().toCharArray();
// if(input[0] >= 'a') {
//     input[0] = (char)(input[0] - 32);
// }
// System.out.println(input);

// 다른 풀이 2
// substring을 이용해서 첫번째 문자를 특정하고 toUpperCase()로 변경

// String input = sc.nextLine();
// System.out.println(input.substring(0, 1).toUpperCase() + input.substring(1));