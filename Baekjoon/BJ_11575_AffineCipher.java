/**
 * @ BJ 11575 Affine Cipher
 * @ prob : https://www.acmicpc.net/problem/11575
 */

import java.util.Scanner;
import java.io.*;

public class BJ_11575_AffineCipher {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int t = sc.nextInt();
        int t = Integer.valueOf(br.readLine());
        // StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            // int a = sc.nextInt(), b = sc.nextInt();
            String[] consts = br.readLine().split(" ");
            int a = Integer.valueOf(consts[0]);
            int b = Integer.valueOf(consts[1]);
            // char[] plainString = sc.next().toCharArray();
            char[] plainString = br.readLine().toCharArray();
            // for(int j = 0; j < plainString.length; j++) {
            //     sb.append(affineCipher(Integer.valueOf(consts[0]), Integer.valueOf(consts[1]), plainString[j]));
            // }
            for(int j = 0; j < plainString.length; j++) {
                plainString[j] = affineCipher(a, b, plainString[j]);
            }
            // sb.append(plainString).append(System.lineSeparator());
            System.out.println(plainString);
        }
        // System.out.println(sb.toString());

        // sc.close();
        br.close();
    }

    static char affineCipher(int a, int b, char plain) {
        return (char)(((a * (plain - 'A') + b) % 26) + 'A');
    }
}

// 시간복잡도 개선 과정
// 소요 시간 : https://www.acmicpc.net/status?from_mine=1&problem_id=11575&user_id=shy625
// 참고 : https://www.acmicpc.net/source/25779135

// 1. 처음 작성한 코드
// https://www.acmicpc.net/source/34342034

// 2. Scanner 대신 BufferedReader 사용 -> -68ms
// https://www.acmicpc.net/source/34342241

// 3. 암호화된 배열 새로 생성하지 않고 입력으로 들어온 배열에 char 단위로 바로 업데이트 -> -144ms
// https://www.acmicpc.net/source/34342461

// 4. 모든 테스트케이스를 StringBuilder로 모아서 출력하지 않고 테스트케이스당 바로 출력 -> -80ms
// https://www.acmicpc.net/source/34342542

// 5. 상수 a, b을 int로 변환하는 부분을 반복문 밖으로 변경 -> -224ms
// https://www.acmicpc.net/source/34342672