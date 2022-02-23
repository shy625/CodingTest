/**
 * SWEA 4047 영준이의 카드 카운팅
 * @ prob : https://bit.ly/3h9lfxo
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4047_영준이의카드카운팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // StringBuilder도 길이 제한이 있기 때문에 가능하면 전체 출력을 모두 담지 않고 테스트케이스 별로 넣고 출력하는 것이 좋다.

        int T = Integer.parseInt(br.readLine());

        outer :
        for(int t = 1; t <= T; t++) {
            sb.append("#" + t);

            boolean[][] deck = new boolean[4][14];  // 카드 종류 및 각 번호의 카드 보유 여부
            int[] cardCount = new int[4];           // 카드 종류별 가지고 있는 카드 개수

            String input = br.readLine();
            for(int i = 0; i < input.length(); i += 3) {    // 3자리씩 확인
                String shape = input.substring(i, i+1);
                int num = Integer.parseInt(input.substring(i+1, i+3));

                switch(shape) {
                    case "S" :
                        if(deck[0][num]) {      // 해당 카드 종류, 번호 카드가 있는 경우 ERROR 출력
                            sb.append(" ERROR\n");
                            continue outer;
                        } else {                // 해당 카드 종류, 번호가 없는 경우 카드 보유 체크 및 개수+1
                            deck[0][num] = true;
                            cardCount[0]++;
                        }
                        break;
                    case "D" :
                        if(deck[1][num]) {
                            sb.append(" ERROR\n");
                            continue outer;
                        } else {
                            deck[1][num] = true;
                            cardCount[1]++;
                        }
                        break;
                    case "H" :
                        if(deck[2][num]) {
                            sb.append(" ERROR\n");
                            continue outer;
                        } else {
                            deck[2][num] = true;
                            cardCount[2]++;
                        }
                        break;
                    case "C" :
                        if(deck[3][num]) {
                            sb.append(" ERROR\n");
                            continue outer;
                        } else {
                            deck[3][num] = true;
                            cardCount[3]++;
                        }
                        break;
                }
            }
            // 카드 종류별 추가로 필요한 카드 개수 출력
            sb.append(" " + (13 - cardCount[0]))
                .append(" " + (13 - cardCount[1]))
                .append(" " + (13 - cardCount[2]))
                .append(" " + (13 - cardCount[3]))
                .append('\n');
        }

        System.out.println(sb.toString());
        
        br.close();
    }
}

// 다른 풀이 1
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do