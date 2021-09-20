/**
 * @ BJ 10807 개수 세기
 * @ prob : https://www.acmicpc.net/problem/10807
 */

import java.util.Scanner;

public class BJ_10807_개수세기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        String[] num = sc.nextLine().split(" ");
        String v = sc.nextLine();
        int count = 0;
        for(int i = 0; i < num.length; i++) {
            if(num[i].equals(v)) {
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}

// 다른 풀이 1
// 들어오는 값을 인덱스로 하여 배열에 count 값 저장

// int[] countArr = new int[201];  // -100 ~ -1, 0, 1 ~ 100
// int n = sc.nextInt();
// for(int i = 0; i < n; i++) {
//     countArr[sc.nextInt()+100]++;
// }
// System.out.println(countArr[sc.nextInt()+100]);