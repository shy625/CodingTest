/**
 * BJ 2493 탑
 * @ prob : https://www.acmicpc.net/problem/2493
 * @ level : G5
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] poles = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            poles[i] = Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();

        int idx = 1;    // 1번 탑부터 시작
        while(idx <= N) {
            if(stack.isEmpty()) {   // 스택이 빈 경우
                sb.append("0 ");    // 0 출력
                stack.push(new int[]{idx, poles[idx]});     // 현재 탑 push
                idx++;      // 다음 탑
            } else if(stack.peek()[1] < poles[idx]) {   // top에 있는 탑의 높이가 현재 탑의 높이 미만인 경우
                stack.pop();
            } else if(stack.peek()[1] >= poles[idx]) {  // top에 있는 탑의 높이가 현재 탑의 높이 이상인 경우
                sb.append(stack.peek()[0]).append(" ");     // top의 인덱스 출력
                stack.push(new int[]{idx, poles[idx]});     // 현재 탑 push
                idx++;      // 다음 탑
            }
        }

        System.out.println(sb.toString());
        
        br.close();
    }
}