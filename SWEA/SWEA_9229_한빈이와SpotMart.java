/**
 * SWEA 9229 한빈이와 Spot Mart
 * @ prob : https://bit.ly/3HBgPuX
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9229_한빈이와SpotMart {

    static int N, M;
    static int[] snacks;
    static int max;
    static int[] pickedSnack;
    static String[] input;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            // N, M 초기화
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            // 과자봉지들의 무게 초기화
            snacks = new int[N];
            input = br.readLine().split(" ");
            for(int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(input[i]);
            }

            pickedSnack = new int[2];
            max = -1;
            // combi(0, 0);
            combi(0, 0, 0);

            System.out.println("#" + t + " " + max);
        }

        br.close();
    }

    // 조합 1
    static void combi(int count, int start) {
        if(count == 2) {
            int sum = pickedSnack[0] + pickedSnack[1];
            if(sum <= M) {  // 두 과자의 합이 최대 무게보다 작으면 max 체크
                max = Math.max(max, sum);
            }
            return;
        }
        for(int i = start; i < N; i++) {
            pickedSnack[count] = snacks[i];
            combi(count + 1, i + 1);
        }
    }

    // 조합 2
    static void combi(int count, int start, int sum) {
        if(count == 2) {
            if(sum <= M) {  // 두 과자의 합이 최대 무게보다 작으면 max 체크
                max = Math.max(max, sum);
            }
            return;
        }
        for(int i = start; i < N; i++) {
            if(sum > M) {   // prooning - 2개를 다 고르기 전에 이미 총합이 M을 넘으면 skip
                continue;
            }
            combi(count + 1, i + 1, sum + snacks[i]);
        }
    }
}

// BufferedReader를 이용한 풀이 - 181ms
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do

// Scanner를 이용한 풀이 - 244ms
// https://swexpertacademy.com/main/code/problem/problemSolverCodeDetail.do