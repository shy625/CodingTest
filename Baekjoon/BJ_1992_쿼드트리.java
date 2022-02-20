/**
 * BJ 1992 쿼드트리
 * @ prob : https://www.acmicpc.net/problem/1992
 * @ level : S1
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {

    static char[][] videoMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        videoMap = new char[N][N];
        for(int i = 0; i < N; i++) {
            videoMap[i] = br.readLine().toCharArray();
        }

        System.out.println(compressQT(0, 0, N));

        br.close();
    }

    // DFS 활용, Merge & Conquer
    private static String compressQT(int r, int c, int n) {
        if(n == 1) {    // Base Condition
            return videoMap[r][c] + "";
        }

        int nn = n >> 1;
        String part1 = compressQT(r, c, nn);    // 1사분면
        String part2 = compressQT(r, c + nn, nn);   // 2사분면
        String part3 = compressQT(r + nn, c, nn);   // 3사분면
        String part4 = compressQT(r + nn, c + nn, nn);  // 4사분면

        String result = "";
        if(isCompressable(part1, part2, part3, part4)) {    // 압축 가능하면 하나로 표현
            result = part1;
        } else {    // 압축 불가능하면 4개를 묶어서 표현
            result = part1 + part2 + part3 + part4;
        }

        return result.length() == 1 ? result : "(" + result + ")";      // 압축된 결과는 괄호 없이, 압축되지 않은 결과는 괄호로 묶기
    }

    // 압축 가능 여부 확인 -> 전체가 0 또는 1로만 되어 있어야 압축 가능
    private static boolean isCompressable(String part1, String part2, String part3, String part4) {        
        if(part1.length() == 1 && part2.length() == 1 && part3.length() == 1 & part4.length() == 1) {   // 각 4분면의 결과가 한 자리이고 (0 or 1)
            if(part1.equals(part2) && part2.equals(part3) && part3.equals(part4)) {     // 각 4분면의 결과가 모두 같으면
                return true;
            }
        }
        return false;
    }
}

// 다른 풀이 1
// 밖에서부터 안으로 들어가는 형식, 가장 큰 사각형에서 모든 원소값을 비교하다가 다른게 있으면 4등분하여 동일 과정 진행
// 내 풀이는 일단 가장 작은 사각형까지 내려간 뒤, 큰 사각형으로 올라오면서 합치는 형식
// https://www.acmicpc.net/source/14582680