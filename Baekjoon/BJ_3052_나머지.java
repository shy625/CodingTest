/**
 * @ BJ 3052 나머지
 * @ prob : https://www.acmicpc.net/problem/3052
 */

import java.util.*;

public class BJ_3052_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] remainders = new int[10];
        int index = 0;
        for(int i = 0; i < 10; i++) {
            int num = sc.nextInt() % 42;
            if(!checkRemainderList(num, remainders, index)) {
                remainders[index++] = num;
            }
        }
        System.out.println(index);

        sc.close();
    }

    static boolean checkRemainderList(int num, int[] remainders, int index) {
        for(int i = 0; i < index; i++) {
            if(num == remainders[i]) {
                return true;
            }
        }
        return false;
    }
}

// 다른 풀이 1
// Set (HashSet) 사용 - Set : 1.순서 상관 없고 2.중복을 허용하지 않는 자료구조

// Set<Integer> remainderSet = new HashSet<>();
// for(int i = 0; i < 10; i++) {
//     int num = sc.nextInt() % 42;
//     remainderSet.add(num);
// }
// System.out.println(remainderSet.size());