/**
 * @ BJ 10828 스택
 * @ prob : https://www.acmicpc.net/problem/10828
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Stack stack = new Stack();
        // List<Integer> stack = new ArrayList<>();
        int[] stack = new int[10000];   // 입력되는 명령어의 개수인 n 크기만큼만 선언해도 OK
        int top = -1;

        // int n = Integer.valueOf(sc.nextLine());
        int n = Integer.valueOf(br.readLine());
        for(int i = 0; i < n; i++) {
            // String[] inputs = sc.nextLine().split(" ");
            String[] inputs = br.readLine().split(" ");
            switch(inputs[0]) {
                case "push" :
                    // stack.push(Integer.valueOf(inputs[1]));
                    // stack.add(Integer.valueOf(inputs[1]));
                    stack[++top] = Integer.valueOf(inputs[1]);
                    break;
                case "pop" :
                    // System.out.println(stack.pop());
                    // System.out.println(top >= 0 ? stack.remove(top--) : top);
                    // System.out.println(top >= 0 ? stack[top--] : top);
                    bw.write((top >= 0 ? stack[top--] : top) + "\n");
                    break;
                case "size" :
                    // System.out.println(stack.size());
                    // System.out.println(stack.size());
                    // System.out.println(top + 1);
                    bw.write((top + 1) + "\n");
                    break;
                case "empty" :
                    // System.out.println(stack.empty());
                    // System.out.println(stack.isEmpty() ? 1 : 0);
                    // System.out.println(top < 0 ? 1 : 0);
                    bw.write((top < 0 ? 1 : 0) + "\n");
                    break;
                case "top" :
                    // System.out.println(stack.top());
                    // System.out.println(top >= 0 ? stack.get(top) : top);
                    // System.out.println(top >= 0 ? stack[top] : top);
                    bw.write((top >= 0 ? stack[top] : top) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
        // sc.close();

        // class Stack {
        //     List<Integer> stack = new ArrayList<>();
        //     int top = -1;

        //     void push(int x) {
        //         if(stack.add(x)) {
        //             top++;
        //         }
        //     }

        //     int pop() {
        //         return top >= 0 ? stack.remove(top--) : top;
        //     }

        //     int size() {
        //         return stack.size();
        //     }

        //     int empty() {
        //         return stack.isEmpty() ? 1 : 0;
        //     }

        //     int top() {
        //         return top >= 0 ? stack.get(top) : top;
        //     }
        // }
    }
}

// 주의
// 입력에 Scanner 사용 시 시간초과 발생
// BufferedReader, BufferedWriter 사용

// 풀이 1
// Java에서 제공하는 Stack 자료구조 사용

// Stack<Integer> stack = new Stack<>();
// int n = Integer.valueOf(sc.nextLine());
// for(int i = 0; i < n; i++) {
//     String[] inputs = sc.nextLine().split(" ");
//     switch(inputs[0]) {
//         case "push" :
//             stack.push(Integer.valueOf(inputs[1]));
//             break;
//         case "pop" :
//             System.out.println(stack.isEmpty() ? -1 : stack.pop());
//             break;
//         case "size" :
//             System.out.println(stack.size());
//             break;
//         case "empty" :
//             System.out.println(stack.isEmpty() ? 1 : 0);
//             break;
//         case "top" :
//             System.out.println(stack.isEmpty() ? -1 : stack.peek());
//             break;
//     }
// }

// 풀이 2
// 배열로 직접 스택 구현하여 사용

// 풀이 3
// ArrayList로 스택 구현하여 사용
