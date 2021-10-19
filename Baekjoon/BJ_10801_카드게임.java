/**
 * @ BJ 10801 카드 게임
 * @ prob : https://www.acmicpc.net/problem/10801
 */

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class BJ_10801_카드게임 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][] game = new int[2][10];
        int winCount = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 10; j++) {
                game[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < 10; i++) {
            if(game[0][i] > game[1][i]) {
                winCount++;
            } else if(game[0][i] < game[1][i]) {
                winCount--;
            }
        }
        System.out.println(winCount > 0 ? "A" : (winCount == 0 ? "D" : "B"));

        sc.close();
    }
}

// 다른 풀이 1
// 한 줄 씩 읽고 StringTokenizer를 이용해 앞에서부터 하나씩 비교

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer stA = new StringTokenizer(br.readLine());
// StringTokenizer stB = new StringTokenizer(br.readLine());
// 
// int winCount = 0;
// for(int i = 0; i < 10; i++) {
//     int cardA = Integer.valueOf(stA.nextToken());
//     int cardB = Integer.valueOf(stB.nextToken());
//     if(cardA > cardB) {
//         winCount++;
//     } else if(cardA < cardB) {
//         winCount--;
//     }
// }
// System.out.println(winCount > 0 ? "A" : (winCount == 0 ? "D" : "B"));
// br.close();

// 다른 풀이 2
// Math.signum() 활용 - 값의 부호를 구하는 메소드
// argument > 0 return 1.0 / argument < 0 return -1.0 / argument == 0 return 0
// https://www.acmicpc.net/source/2974114