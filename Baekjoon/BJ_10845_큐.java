/**
 * @ BJ 10845 큐
 * @ prob : https://www.acmicpc.net/problem/10845
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();

        int n = Integer.valueOf(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            switch(inputs[0]) {
                case "push" :
                    queue.add(Integer.valueOf(inputs[1]));
                    break;
                case "pop" :
                    bw.write((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;
                case "size" :
                    bw.write((queue.size()) + "\n");
                    break;
                case "empty" :
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front" :
                    bw.write((queue.isEmpty() ? -1 : queue.getFirst()) + "\n");
                    break;
                case "back" :
                    bw.write((queue.isEmpty() ? -1 : queue.getLast()) + "\n");
                    break;
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}

// 다른 풀이 1
// ArrayDeque로 Queue 구현

// class Queue_Deque {
//     Deque<Integer> queue = new ArrayDeque<>();
// 
//     void push(int x) {
//         // queue.add(x);   // 크기가 제한된 Deque에서 overflow 발생 시 exception
//         queue.offer(x); // 크기가 제한된 Deque에서 overflow 발생 시 false
//     }
//     int pop() {
//         // return queue.pop();     // underflow 발생 시 exception
//         Integer x;
//         return (x = queue.poll()) != null ? x : -1;     // underflow 발생 시 null
//     }
//     int size() {
//         return queue.size();
//     }
//     int empty() {
//         return queue.isEmpty() ? 1 : 0;
//     }
//     int front() {
//         // return queue.getFirst();    // underflow 발생 시 exception
//         Integer x;
//         return (x = queue.peekFirst()) != null ? x : -1;   // underflow 발생 시 null
//     }
//     int back() {
//         // return queue.getLast();     // underflow 발생 시 exception
//         Integer x;
//         return (x = queue.peekLast()) != null ? x : -1;    // underflow 발생 시 null
//     }
// }

// 다른 풀이 2
// 배열로 구현

// class Queue_Array {
//     int[] queue;
//     int front = 0;
//     int back = 0;
// 
//     public Queue_Array(int n) {
//         this.queue = new int[n];
//     }
// 
//     void push(int x) {
//         queue[back++] = x;
//     }
//     int pop() {
//         return size() != 0 ? queue[front++] : -1;
//     }
//     int size() {
//         return back - front;
//     }
//     int empty() {
//         return size() == 0 ? 1 : 0;
//     }
//     int front() {
//         return size() != 0 ? queue[front] : -1;
//     }
//     int back() {
//         return size() != 0 ? queue[back-1] : -1;
//     }
// }
