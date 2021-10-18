/**
 * @ BJ 2789 유학 금지
 * @ prob : https://www.acmicpc.net/problem/2789
 */

import java.util.Scanner;

public class BJ_2789_유학금지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String output = input.replaceAll("[CAMBRIDGE]", "");
        System.out.println(output);

        sc.close();
    }
}

// 다른 풀이 1
// input의 char 별로 검사하여 해당되지 않으면 출력

// for(int i = 0; i < input.length(); i++) {
//     if(!"CAMBRIDGE".contains(input.charAt(i)) {
//         sb.append(input.charAt(i));
//     }
// }
// System.out.println(sb);