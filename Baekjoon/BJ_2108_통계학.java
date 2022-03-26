/**
 * BJ 2108 통계학
 * @ prob : https://www.acmicpc.net/problem/2108
 * @ level : S3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        int sum = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] freq = new int[8001];
        int maxFreq = 0;

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            maxFreq = Math.max(maxFreq, ++freq[nums[i] + 4000]);
        }
        Arrays.sort(nums);

        System.out.println(Math.round((double)sum / N));    // 산술평균
        System.out.println(nums[N/2]);  // 중앙값
        // 최빈값
        List<Integer> maxFreqList = new ArrayList<>();
        for(int i = min + 4000; i <= max + 4000; i++) {
            if(maxFreq == freq[i]) {
                maxFreqList.add(i);
            }
        }
        if(maxFreqList.size() == 1) {
            System.out.println(maxFreqList.get(0) - 4000);
        } else {
            System.out.println(maxFreqList.get(1) - 4000);
        }
        System.out.println(max - min);  // 범위

        br.close();
    }
}
