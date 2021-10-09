/**
 * @ BJ 2920 음계
 * @ prob : https://www.acmicpc.net/problem/2920
 */

import java.util.Scanner;

public class BJ_2920_음계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int ASC = 1, DES = 2, MIX = 3;

        int type = 0;
        int start = sc.nextInt();
        if(start == 1) {
            type = ASC;
            for(int i = 2; i <= 8; i++) {
                if(sc.nextInt() != i) {
                    type = MIX;
                    break;
                }
            }
        } else if(start == 8) {
            type = DES;
            for(int i = 7; i >= 1; i--) {
                if(sc.nextInt() != i) {
                    type = MIX;
                    break;
                }
            }
        } else {
            type = MIX;
        }
        System.out.println(type == ASC ? "ascending" : (type == DES ? "descending" : "mixed"));

        sc.close();
    }
}

// 다른 풀이 1
// ascending, descending에 해당하는 입력을 미리 문자열로 저장하여 비교

// String asc = "1 2 3 4 5 6 7 8";
// String des = "8 7 6 5 4 3 2 1";
// String input = sc.nextLine();
// System.out.println(input.equals(asc) ? "ascending" : (input.equals(des) ? "descending" : "mixed"));

// 다른 풀이 2
// 배열로 저장하여 이전 입력과 비교했을 때 1씩 증가 또는 감소하는지 확인

// String[] inputs = sc.nextLine().split(" ");
// int[] arr = new int[inputs.length];
// String result = "";
// for(int i = 0; i < 8; i++) {
//     arr[i] = Integer.valueOf(inputs[i]);
// }
// for(int i = 0; i < arr.length-1; i++) {
//     if(arr[i+1] == arr[i] + 1) {
//         result = "ascending";
//     } else if(arr[i+1] == arr[i] - 1) {
//         result = "descending";
//     } else {
//         result = "mixed";
//         break;
//     }
// }
// System.out.println(result);
