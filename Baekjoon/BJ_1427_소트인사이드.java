/**
 * @ BJ 1427 소트인사이드
 * @ prob : https://www.acmicpc.net/problem/1427
 */

import java.util.*;

public class BJ_1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        list.sort(Comparator.reverseOrder());
        for(int i : list) {
            System.out.print(i);
        }

        sc.close();
    }
}

// 다른 풀이
// int로 받는지, char[]로 받는지, String으로 받는지에 따라
// 오름차순 정렬하여 거꾸로 출력하는지, 내림차순 정렬하여 그대로 출력하는지 등에 따라 다양한 풀이가 있을 수 있다.

// String[] n = sc.nextLine().split("");
// Arrays.sort(n); // Arrays.sort(n, Collections.reverseOrder());
// String result = "";
// for(String s : n) {
//     result = s + result;
// }
// System.out.println(result);