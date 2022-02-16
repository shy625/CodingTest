/**
 * @ SWEA 6808 규영이와 인영이의 카드게임
 * @ prob : https://bit.ly/3rRK3jx
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6808_규영이와인영이의카드게임 {

    static int[] player1;
    static int[] player2;
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            String[] inputs = br.readLine().split(" ");

            player1 = new int[9];
            player2 = new int[9];
            boolean[] cardCheck = new boolean[18];

            // 규영이 카드 세팅
            for(int i = 0; i < 9; i++) {
                player1[i] = Integer.parseInt(inputs[i]);
                cardCheck[player1[i]-1] = true;
            }
            // 인영이 카드 세팅
            int idx = 0;
            for(int i = 0; i < 18; i++) {
                if(!cardCheck[i]) {
                    player2[idx++] = i + 1;
                }
            }
            
            winCount = 0;
            loseCount = 0;

            // next permutation 이용
            do {
                // 승패 체크
                if(checkWinner(player2) == 1) {
                    winCount++;
                } else if(checkWinner(player2) == -1) {
                    loseCount++;
                }
            } while (np(player2.length));

            // 비트마스킹 순열 이용
            // perm(0, 0, new int[9]);

            sb.append("#" + t).append(" " + winCount).append(" " + loseCount).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
        
        br.close();
    }

    // 비트마스킹 순열
    private static void perm(int count, int flag, int[] cards) {
        if(count == 9) {
            // 승패 체크
            if(checkWinner(cards) == 1) {
                winCount++;
            } else if(checkWinner(cards) == -1) {
                loseCount++;
            }
            return;
        }
        for(int i = 0; i < 9; i++) {
            if((flag & 1 << i) != 0) {
                continue;
            }
            cards[count] = player2[i];
            perm(count + 1, flag | 1 << i, cards);
        }
    }

    // next permutation
    private static boolean np(int n) {
        int i = n - 1;
        while(i > 0 && player2[i-1] >= player2[i]) {
            i--;
        }
        if(i == 0) {
            return false;
        }

        int j = n - 1;
        while(player2[i-1] > player2[j]) {
            j--;
        }

        swap(i-1, j);

        int k = n - 1;
        while(i < k) {
            swap(i++, k--);
        }
        return true;
    }

    private static void swap(int i, int j) {
        int tmp = player2[i];
        player2[i] = player2[j];
        player2[j] = tmp;
    }

    // 게임 결과
    private static int checkWinner(int[] player2) {
        int score1 = 0, score2 = 0;
        for(int i = 0; i < 9; i++) {
            if(player1[i] > player2[i]) {
                score1 += player1[i] + player2[i];
            } else {
                score2 += player1[i] + player2[i];
            }
        }
        return score1 > score2 ? 1 : (score1 < score2 ? -1 : 0);
    }
}