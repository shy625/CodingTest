/**
 * @ BJ 2774 아름다운 수
 * @ prob : https://www.acmicpc.net/problem/2774
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_2774_아름다운수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            Set<Character> set = new HashSet<>();
            String x = sc.next();
            for(int j = 0; j < x.length(); j++) {
                set.add(x.charAt(j));
            }
            // int x = sc.nextInt();
            // while(x > 0) {
            //     set.add(x % 10);
            //     x /= 10;
            // }
            System.out.println(set.size());
        }

        sc.close();
    }
}

// 다른 풀이 1
// 각 숫자별 등장 횟수를 세는 배열을 만들고 마지막에 등장 횟수가 1이상인 숫자를 세서 출력
// https://www.acmicpc.net/source/3529862
// https://www.acmicpc.net/source/4569628

// int[] digit = new int[10];
// while(x > 0) {
//     digit[x % 10]++;
//     x /= 10;
// }
// for(int i = 0; i < digit.length; i++) {
//     if(digit[i] > 0) {
//         count++;
//     }
// }

// 다른 풀이 2
// 0부터 9가 각각 숫자에 포함되어 있는지를 확인하여 있으면 카운트
// https://www.acmicpc.net/source/9410045

// for(char ch = '0'; ch <= '9'; ch++) {
//     if(x.indexOf(ch) != -1) {
//         count++;
//     }
// }