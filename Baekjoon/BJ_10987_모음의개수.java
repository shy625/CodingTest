/**
 * @ BJ 10987 모음의 개수
 * @ prob : https://www.acmicpc.net/problem/10987
 */

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10987_모음의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] vowels = {"a", "e", "i", "o", "u"};
        String input = sc.nextLine();
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if(Arrays.asList(vowels).contains(input.charAt(i)+"")) {
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}

// 다른 풀이 1
// replaceAll() 이용하여 모음만 남기고 나머지 문자 삭제

// System.out.println(input.replaceAll("[^aeiou]", "").length());

// 다른 풀이 2
// 반복문으로 문자열의 문자 하나씩 확인

// for(char ch : input.toCharArray()) {
//     if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
//         count++;
//     }
// }
// System.out.println(count);

// 다른 풀이 3
// String의 contains() 활용

// for(int i = 0; i < input.length(); i++) {
//     if("aeiou".contains(input.subSequence(i, i+1))) {
//         count++;
//     }
// }
// System.out.println(count);