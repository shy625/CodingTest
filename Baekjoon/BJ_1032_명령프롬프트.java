/**
 * @ BJ 1032 명령 프롬프트
 * @ prob : https://www.acmicpc.net/problem/1032
 */

import java.util.Scanner;

public class BJ_1032_명령프롬프트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] files = new String[n];
        for(int i = 0; i < files.length; i++) {
            files[i] = sc.next();
        }

        String pattern = "";
        for(int i = 0; i < files[0].length(); i++) {
            char ch = files[0].charAt(i);
            boolean isSameAll = true;
            for(int j = 1; j < files.length; j++) {
                if(ch != files[j].charAt(i)) {
                    isSameAll = false;
                    break;
                }
            }
            if(isSameAll) {
                pattern += ch;
            } else {
                pattern += '?';
            }
        }

        System.out.println(pattern);

        sc.close();
    }
}

// 다른 풀이 1
// 모두 같은지 확인하는 boolean 변수를 따로 둘 필요 없이 일단 pattern에 붙이고 다르면 ? 로 변경

// char[] pattern = new char[files[0].length()];
// for(int i = 0; i < files[0].length(); i++) {
//     pattern[i] = files[0].charAt(i);
//     for(int j = 1; j < files.length; j++) {
//         if(pattern[i] != files[j].charAt(i)) {
//             pattern[i] = '?';
//             break;
//         }
//     }
// }