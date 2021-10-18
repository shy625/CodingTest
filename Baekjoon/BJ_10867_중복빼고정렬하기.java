/**
 * @ BJ 10867 중복 빼고 정렬하기
 * @ prob : https://www.acmicpc.net/problem/10867
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BJ_10867_중복빼고정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new TreeSet<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        sc.close();
    }
}

// 다른 풀이 1
// 배열 사용

// boolean[] arr = new boolean[2001];
// for(int i = 0; i < n; i++) {
//     arr[i + 1000] = true;
// }
// for(int i = 0; i < 2001; i++) {
//     if(arr[i] {
//         System.out.print(i - 1000 + " ");
//     })
// }