/**
 * SWEA 1859 백만 장자 프로젝트
 * @ prob : https://bit.ly/33Xu2Pq
 * @ level : D2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1859_백만장자프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(input[i]);
            }

            int startIdx = 0;
            int max = 0, maxIdx = 0;
            long profit = 0L;

            while(true) {
                for(int i = startIdx; i < n; i++) {
                    if(nums[i] > max) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }

                for(int i = startIdx; i < maxIdx; i++) {
                    profit += max - nums[i];
                }
                
                startIdx = maxIdx + 1;
                max = 0;

                if(maxIdx == n - 1) {
                    break;
                }
            }
            System.out.println("#" + t + " " + profit);
            
            startIdx = 0;
            max = 0;
            maxIdx = 0;
            profit = 0L;
        }

        br.close();
    }
}

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.Collections;
//
// public class SWEA_1859_백만장자프로젝트 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//         int T = Integer.parseInt(br.readLine());
//
//         for(int t = 1; t <= T; t++) {
//             int n = Integer.parseInt(br.readLine());
//             String[] input = br.readLine().split(" ");
//             Integer[] nums = new Integer[n];
//             for(int i = 0; i < n; i++) {
//                 nums[i] = Integer.valueOf(input[i]);
//             }
//
//             Integer[] sortedNums = nums.clone();
//             Arrays.sort(sortedNums, Collections.reverseOrder());
//
//             int buySum = 0, buyCount = 0;
//             int profit = 0;
//             int next = 0;
//             for(int i = 0; i < n; i++) {
//                 if(nums[i].equals(sortedNums[next])) {
//                     profit += sortedNums[next] * buyCount - buySum;
//                     buySum = 0;
//                     buyCount = 0;
//                     next++;
//                 } else {
//                     buySum += nums[i];
//                     buyCount++;
//                 }
//             }
//             System.out.println("#" + t + " " + profit);
//         }
//        
//         br.close();
//     }
// }
