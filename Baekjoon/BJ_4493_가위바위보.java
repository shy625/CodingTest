/**
 * @ BJ 4493 가위 바위 보?
 * @ prob : https://www.acmicpc.net/problem/4493
 */

import java.util.Scanner;
import java.io.*;

public class BJ_4493_가위바위보 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // int t = Integer.valueOf(sc.nextLine());
        int t = Integer.valueOf(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine());
            int[] winCount = new int[2];
            for(int j = 0; j < n; j++) {
                // String[] choices = sc.nextLine().split(" ");
                String[] choices = br.readLine().split(" ");
                if(checkPlayer1Win(choices) > 0) {
                    winCount[0]++;
                } else if(checkPlayer1Win(choices) < 0) {
                    winCount[1]++;
                }
            }
            if(winCount[0] > winCount[1]) {
                // System.out.println("Player 1");
                sb.append("Player 1\n");
            } else if(winCount[0] == winCount[1]) {
                // System.out.println("TIE");
                sb.append("TIE\n");
            } else {
                // System.out.println("Player 2");
                sb.append("Player 2\n");
            }
        }
        System.out.println(sb);
        br.close();
        // sc.close();
    }

    static int checkPlayer1Win(String[] choices) {
        int player1Win = -1;
        if((choices[0].equals("R") && choices[1].equals("S"))
            || (choices[0].equals("S") && choices[1].equals("P"))
            || (choices[0].equals("P") && choices[1].equals("R"))) {
            player1Win = 1;
        } else if(choices[0].equals(choices[1])) {
            player1Win = 0;
        }
        return player1Win;
    }
}

// 다른 풀이 1
// 큰 풀이 구조는 내 답안과 다른 풀이들 모두 동일
// 입력을 어떤 형태로 받아 처리했는지에서 차이

// https://www.acmicpc.net/source/5712988
// https://www.acmicpc.net/source/5756532
// https://www.acmicpc.net/source/9934492