/**
 * @ BJ 2309 일곱 난쟁이
 * @ prob : https://www.acmicpc.net/problem/2309
 */

import java.util.*;

public class BJ_2309_일곱난쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = new int[9];
        for(int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }

        int sum = 0;
        List<Integer> reals = new ArrayList<>();
        while(sum != 100) { // list에 담긴 값의 합이 100이 될 때까지 반복
            sum = 0;
            reals.clear();
            while(reals.size() < 7) {   // 9개 중 랜덤하고 중복되지 않게 7개를 뽑아서 list에 저장
                int random = (int)(Math.random() * heights.length);
                if(!reals.contains(heights[random])) {
                    sum += heights[random];
                    reals.add(heights[random]);
                }
            }
        }

        // 선택된 7개가 담긴 list를 정렬하여 출력
        reals.sort(Comparator.naturalOrder());
        for(Integer i : reals) {
            System.out.println(i);
        }

        sc.close();
    }
}

// 다른 풀이 1
// 9명의 전체 키 합에서 뺏을 때 나머지 합이 100이 되는 키 값을 찾아서 제외

// int[] heights = new int[9];
// int sum = 0;
// for(int i = 0; i < heights.length; i++) {
//     heights[i] = sc.nextInt();
//     sum += heights[i];
// }
// 
// // 방법 1 : 제외되는 두 수를 찾은 상태 그대로 반복문 내에서 두 수를 제외하고 출력
// Arrays.sort(heights);
// for(int i = 0; i < heights.length-1 ; i++) {
//     for(int j = i+1; j < heights.length; j++) {
//         if((sum-heights[i]-heights[j]) == 100) {
//             for(int k = 0; k < heights.length; k++) {
//                 if(k == i || k == j) {
//                     continue;
//                 }
//                 System.out.println(heights[k]);
//             }
//         }
//     }
// }
// // 1
// // 방법 2 : 두 수를 찾아서 표시 후, 반복문 종료하고 두 수를 제외하여 출력
// for(int i = 0; i < heights.length-1 ; i++) {
//     for(int j = i+1; j < heights.length; j++) {
//         if((sum-heights[i]-heights[j]) == 100) {
//             heights[i] = 0;
//             heights[j] = 0;
//             }
//         }
//     }
// }
// Arrays.sort(heights);
// for(int i = 2; i < heights.length; i++) {
//     System.out.println(heights[i]);
// }
// // 2