/**
 * BJ 1759 암호 만들기
 * @ prob : https://www.acmicpc.net/problem/1759
 * @ level : G5
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1759_암호만들기 {

    static StringBuilder sb = new StringBuilder();;
    static int L;
    static int C;
    static String[] alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        L = Integer.parseInt(inputs[0]);
        C = Integer.parseInt(inputs[1]);

        alphabets = br.readLine().split(" ");

        // 사전순 정렬
        Arrays.sort(alphabets);
        
        combi(0, 0, new String[L]);

        System.out.println(sb.toString());
        
        br.close();
    }

    // 조합
    private static void combi(int count, int start, String[] password) {
        if(count == L) {
            if(checkCount(password)) {
                for(int i = 0; i < L; i++) {
                    sb.append(password[i]);
                }
                sb.append(System.lineSeparator());
            }
            return;
        }
        for(int i = start; i < C; i++) {
            password[count] = alphabets[i];
            combi(count + 1, i + 1, password);
        }
    }

    // 모음, 자음 최소 개수 조건 체크
    private static boolean checkCount(String[] password) {
        int vCount = 0, cCount = 0;
        for(int i = 0; i < password.length; i++) {
            if("aeiou".contains(password[i])) {
                vCount++;
            } else {
                cCount++;
            }
        }
        return vCount >= 1 && cCount >= 2;
    }
}

// 풀이 1
// combi() 메소드에 password를 String[] 로 설정
// 132ms
// 위의 풀이 코드

// 풀이 2
// combi() 메소드에 password를 String으로 설정
// 152ms

// combi(0, 0, "");
//
// private static void combi(int count, int start, String password) {
//     if(count == L) {
//         if(checkCount(password)) {
//             sb.append(password).append(System.lineSeparator());
//         }
//         return;
//     }
//     for(int i = start; i < C; i++) {
//         combi(count + 1, i + 1, password + alphabets[i]);
//     }
// }
//
// private static boolean checkCount(String password) {
//     int vCount = 0, cCount = 0;
//     for(int i = 0; i < password.length(); i++) {
//         if("aeiou".contains(password.charAt(i) + "")) {
//             vCount++;
//         } else {
//             cCount++;
//         }
//     }
//     return vCount >= 1 && cCount >= 2;
// }