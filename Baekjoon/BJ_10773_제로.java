/**
 * @ BJ 10773 제로
 * @ prob : https://www.acmicpc.net/problem/10773
 */

import java.util.Scanner;
import java.util.Stack;

public class BJ_10773_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        Stack<Integer> numStack = new Stack<>();
        for(int i = 0; i < k; i++) {
            int next = sc.nextInt();
            if(next == 0) {
                numStack.pop();
            } else {
                numStack.push(next);
            }
        }

        int sum = 0;
        while(numStack.size() != 0) {
            sum += numStack.pop();
        }
        // stack size 체크 없이 향상된 for문(for each) 이용해도 ok -> EmptyStackException 발생 x
        // for(int i : numStack) {
        //     sum += i;
        // }
        System.out.println(sum);

        sc.close();
    }
}

// 다른 풀이 1
// 배열의 index를 옮기면서 stack처럼 이용

// int k = sc.nextInt();
// int[] stack = new int[k];
// int cur = 0, sum = 0;
// for(int i = 0; i < k; i++) {
//     int next = sc.nextInt();
//     if(next == 0) {
//         // sum -= stack[--cur];
//         cur--;
//         sum -= stack[cur];
//     } else {
//         // sum += (stack[cur++] = next);
//         stack[cur] = next;
//         sum += stack[cur];
//         cur++;
//     }
// }
// System.out.println(sum);