/**
 * @ BJ 1157 단어 공부
 * @ prob : https://www.acmicpc.net/problem/1157
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1157_단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] alphabets = new int[26];
        String input = sc.nextLine().toUpperCase();
        int max = 0;

        for(int i = 0; i < input.length(); i++) {   // 각 알파벳 출현 카운트로 초기화
            max = Math.max(++alphabets[input.charAt(i)-'A'], max);
        }

        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < alphabets.length; i++) {     // 가장 많이 등장한 값과 같은 값을 리스트에 저장
            if(alphabets[i] == max) {
                count.add(i);
            }
        }

        System.out.println(count.size() > 1 ? "?" : (char)(count.get(0) + 'A'));    // 리스트에 두 개 이상 있으면 ?, 하나면 해당 알파벳 출력

        sc.close();
    }
}

// 다른 풀이 1
// alphabets 배열 채워가면서 max 값과 같은 값이 있는지도 힌번에 체크

// int[] alphabets = new int[26];
// String input = sc.nextLine().toUpperCase();
// int max = 0;
// char maxAlpha = 0;
// for(int i = 0; i < input.length(); i++) {
//     int index = input.charAt(i)-'A';
//     alphabets[index]++;
//     if(alphabets[index] > max) {
//         max = alphabets[index];
//         maxAlpha = input.charAt(i);
//     } else if(alphabets[index] == max) {
//         maxAlpha = '?';
//     }
// }
// System.out.println(maxAlpha);