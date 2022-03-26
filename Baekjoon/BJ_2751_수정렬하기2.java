/**
 * BJ 2751 수 정렬하기 2
 * @ prob : https://www.acmicpc.net/problem/2751
 * @ level : S5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2751_수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for(int i = 0; i < N; i++) {
            sb.append(nums[i]).append(System.lineSeparator());
        }

        System.out.println(sb.toString());
        
        br.close();
    }
}

// 다른 풀이 1
// 등장하는 수의 범위만큼의 배열을 생성하고 등장 여부를 체크한 뒤 배열의 앞에서부터 등장한 수를 출력
// https://www.acmicpc.net/source/3408882