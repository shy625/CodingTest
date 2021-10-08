/**
 * @ BJ 10866 덱
 * @ prob : https://www.acmicpc.net/problem/10866
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.valueOf(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            switch(inputs[0]) {
                case "push_front" :
                    deque.offerFirst(Integer.valueOf(inputs[1]));
                    break;
                case "push_back" :
                    deque.offerLast(Integer.valueOf(inputs[1]));
                    break;
                case "pop_front" :
                    // bw.write((deque.isEmpty() ? -1 : deque.pollFirst()) + "\n");
                    sb.append((deque.isEmpty() ? -1 : deque.pollFirst()) + "\n");
                    break;
                case "pop_back" :
                    // bw.write((deque.isEmpty() ? -1 : deque.pollLast()) + "\n");
                    sb.append((deque.isEmpty() ? -1 : deque.pollLast()) + "\n");
                    break;
                case "size" :
                    // bw.write(deque.size() + "\n");
                    sb.append(deque.size() + "\n");
                    break;
                case "empty" :
                    // bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                    sb.append((deque.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front" :
                    // bw.write((deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
                    sb.append((deque.isEmpty() ? -1 : deque.peekFirst()) + "\n");
                    break;
                case "back" :
                    // bw.write((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    sb.append((deque.isEmpty() ? -1 : deque.peekLast()) + "\n");
                    break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}