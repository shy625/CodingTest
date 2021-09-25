/**
 * @ BJ 3058 짝수를 찾아라
 * @ prob : https://www.acmicpc.net/problem/3058
 */

import java.util.*;

public class BJ_3058_짝수를찾아라 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            List<Integer> evenNumList = new ArrayList<>();
            int sum = 0;
            for(int j = 0; j < 7; j++) {
                int num = sc.nextInt();
                if(num % 2 == 0) {
                    evenNumList.add(num);
                    sum += num;
                }
            }
            evenNumList.sort(Comparator.naturalOrder());
            System.out.println(sum + " " + evenNumList.get(0));
        }

        sc.close();
    }
}

// 다른 풀이 1
// 최솟값을 찾기 위해서 짝수를 List에 저장 후 정렬할 필요 없이 바로 확인하여 최솟값만 저장

// int sum = 0, min = 100;
// for(int j = 0; j < 7; j++) {
//     int num = sc.nextInt();
//     if(num % 2 == 0) {
//         sum += num;
//         min = Math.min(min, num);
//     }
// }
// System.out.println(sum + " " + min);