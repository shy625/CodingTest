/**
 * @ BJ 5656 비교 연산자
 * @ prob : https://www.acmicpc.net/problem/5656
 */

import java.io.*;

public class BJ_5656_비교연산자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        int i = 1;
        outer :
        while(true) {
            String[] inputs = br.readLine().split(" ");
            // if(inputs[1].equals("E")) {
            //     break;
            // }
            // sb.append("Case " + i++ + ": ");
            int a = Integer.valueOf(inputs[0]);
            int b = Integer.valueOf(inputs[2]);
            switch(inputs[1]) {
                case ">" :
                    // sb.append((Integer.valueOf(inputs[0]) > Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");
                    System.out.println("Case " + i++ + ": " + (a > b ? "true" : "false"));
                    break;

                case ">=" :
                    // sb.append((Integer.valueOf(inputs[0]) >= Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");
                    System.out.println("Case " + i++ + ": " + (a >= b ? "true" : "false"));
                    break;
                
                case "<" :
                    // sb.append((Integer.valueOf(inputs[0]) < Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");
                    System.out.println("Case " + i++ + ": " + (a < b ? "true" : "false"));
                    break;
                
                case "<=" :
                    // sb.append((Integer.valueOf(inputs[0]) <= Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");
                    System.out.println("Case " + i++ + ": " + (a <= b ? "true" : "false"));
                    break;
                    
                case "==" :
                    // sb.append((Integer.valueOf(inputs[0]) == Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");     // Reference 타입끼리의 비교는 equals()를 사용해야 한다.
                    System.out.println("Case " + i++ + ": " + (a == b ? "true" : "false"));
                    break;
                    
                case "!=" :
                    // sb.append((Integer.valueOf(inputs[0]) != Integer.valueOf(inputs[2]) ? "true" : "false") + "\n");     // Reference 타입끼리의 비교는 equals()를 사용해야 한다.
                    System.out.println("Case " + i++ + ": " + (a != b ? "true" : "false"));
                    break;
                
                case "E" :
                    break outer;
            }
        }
        // System.out.println(sb);

        br.close();
    }
}