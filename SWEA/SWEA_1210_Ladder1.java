/**
 * SWEA 1210 Ladder1
 * @ prob : https://bit.ly/34O0GUq
 * @ level : D4
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1210_Ladder1 {

    static int N = 100;
    static String[][] ladders = new String[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t = 1; t <= 10; t++) {
            br.readLine();  // 테스트 케이스 번호

            for(int i = 0; i < N; i++) {
                ladders[i] = br.readLine().split(" ");
            }

            int r = N - 1, c = 0;
            for(int i = 0; i < N; i++) {
                if(ladders[r][i].equals("2")) {
                    c = i;
                    break;
                }
            }

            // 0번째 행에 도착하면 종료
            while(r != 0) {
                if(0 <= c - 1 && ladders[r][c-1].equals("1")) {     // 왼쪽에 막대가 있는 경우
                    while(true) {
                        if(c == 0) {    // 왼쪽 끝이면 멈춤!!
                            break;
                        } else if(0 <= c - 1 && ladders[r][--c].equals("0")) {    // 왼쪽으로 갔는데 0이면 돌아오기
                            c++;
                            break;
                        }
                    }
                } else if(c + 1 < N && ladders[r][c+1].equals("1")) {     // 오른쪽에 막대가 있는 경우
                    while(true) {
                        if(c == N - 1) {    // 오른쪽 끝이면 멈춤!!
                            break;
                        } else if(c + 1 < N && ladders[r][++c].equals("0")) {    // 오른쪽으로 갔는데 0이면 돌아오기
                            c--;
                            break;
                        }
                    }
                }
                r--;
            }

            System.out.println("#" + t + " " + c);
        }

        br.close();
    }
}