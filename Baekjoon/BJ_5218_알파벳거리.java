/**
 * @ BJ 5218 알파벳 거리
 * @ prob : https://www.acmicpc.net/problem/5218
 */

import java.util.Scanner;

public class BJ_5218_알파벳거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String xString = sc.next(), yString = sc.next();
            System.out.print("Distances: ");
            for(int j = 0; j < xString.length(); j++) {
                if(yString.charAt(j) >= xString.charAt(j)) {
                    System.out.print(yString.charAt(j) - xString.charAt(j) + " ");
                } else {
                    System.out.print(yString.charAt(j) + 26 - xString.charAt(j) + " ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

// 다른 풀이 1
// 조건식을 변형하여 if문 하나로 해결

// String xString = sc.next(), yString = sc.next();
// System.out.print("Distances: ");
// for(int j = 0; j < xString.length(); j++) {
//     int d = yString.charAt(j) - xString.charAt(j);
//     if(d < 0) {
//         d += 26;
//     }
//     System.out.print(d + " ");
// }
// System.out.println();