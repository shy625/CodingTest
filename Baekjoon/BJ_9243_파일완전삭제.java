/**
 * @ BJ 9243 파일 완전 삭제
 * @ prob : https://www.acmicpc.net/problem/9243
 */

import java.util.Scanner;

public class BJ_9243_파일완전삭제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String before = sc.next();
        String after = sc.next();

        char[] tmp = before.toCharArray();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < tmp.length; j++) {
                if(tmp[j] == '0') {
                    tmp[j] = '1';
                } else if(tmp[j] == '1') {
                    tmp[j] = '0';
                }
            }
        }

        System.out.println(after.equals(new String(tmp)) ? "Deletion succeeded" : "Deletion failed");

        sc.close();
    }
}

// 다른 풀이 1
// 짝수번 변환하면 다시 원래대로 돌아온다는 성질을 이용해 반복 횟수 줄이기
// 변환이 제대로 완료되었다면 짝수번 변환했을 때 모든 자리가 같아야 하고, 홀수번 변환했을 때 모든 자리가 달라야 한다.

// boolean result = true;
// if(n % 2 == 0) {
//     result = after.equals(before);
// } else {
//     for(int i = 0; i < before.length(); i++) {
//         if(before.charAt(i) == after.charAt(i)) {
//             result = false;
//             break;
//         }
//     }
// }
// System.out.println(result ? "Deletion succeeded" : "Deletion failed" );