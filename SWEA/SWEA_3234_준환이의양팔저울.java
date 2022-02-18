/**
 * SWEA 3234 준환이의 양팔저울
 * @ prob : https://bit.ly/3Jys5bW
 * @ level : D4
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3234_준환이의양팔저울 {

    static int N;
    static int total;
    // static int[] weights;
    // static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            String[] inputs = br.readLine().split(" ");
            int[] weights = new int[N];
            for(int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(inputs[i]);
            }

            // isSelected = new boolean[N];
            total = 0;
            permNsubset(0, 0, 0, new boolean[N], weights);

            // sb.append("#" + t + " " + total).append(System.lineSeparator());
            System.out.println("#" + t + " " + total);
        }
        // System.out.println(sb.toString());

        br.close();
    }

    // 순열 + 부분집합
    private static void permNsubset(int count, int rSum, int lSum, boolean[] isSelected, int[] weights) {
        if(rSum > lSum) {   // 진행 중 오른쪽 무게가 왼쪽 무게보다 커지면 바로 종료
            return;
        }
        if(count == weights.length) {   // 오른쪽 무게가 왼쪽 무게보다 커지지 않게 모든 추를 놓으면 total 증가 후 종료
            total++;
            return;
        }
        for(int i = 0; i < weights.length; i++) {
            if(isSelected[i]) {     // 이미 선택되어 있으면 continue
                continue;
            }
            isSelected[i] = true;   // 선택 처리
            permNsubset(count + 1, rSum + weights[i], lSum, isSelected, weights);   // 오른쪽에 추가
            permNsubset(count + 1, rSum, lSum + weights[i], isSelected, weights);   // 왼쪽에 추가
            isSelected[i] = false;  // 선택 해제 처리
        }
    }
}

// 풀이 1
// isSelected, weights 배열을 클래스변수로 생성하여 permNsubset() 메소드에서 사용
// -> 2002ms 시초

// 풀이 2
// isSelected, weights 배열 지역변수로 생성 후 파라미터로 permNsubset 메소드에 전달
// -> 1674ms 통과

// 풀이 3 (예정)
// 순열을 진행하면서 부분집합까지 한번에 진행하지 않고 분리해서 풀어보기

// 풀이 4 (예정)
// 비트마스킹, NP 등 다른 방식으로 순열 구해보기