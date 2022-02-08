/**
 * SWEA 1228 암호문1
 * @ prob : https://bit.ly/3oxNji3
 * @ level : D3
 * @ Blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedList<String> numList = new LinkedList<>();

        for(int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            
            // 원본 암호문 초기화
            String[] origin = br.readLine().split(" ");
            for(int i = 0; i < N; i++) {
                numList.add(origin[i]);
            }

            String commandCount = br.readLine();    // 명령어 개수, 사용 X
            String commandLine = br.readLine();
            StringTokenizer st = new StringTokenizer(commandLine, " ");

            // 명령어 전체 문장이 끝날 때까지 반복
            while(st.hasMoreTokens()) {
                // I 가 나오면 명령어 처리
                if(st.nextToken().equals("I")) {
                    int x = Integer.parseInt(st.nextToken());   // 추가 위치
                    int y = Integer.parseInt(st.nextToken());   // 추가 개수

                    for(int i = 0; i < y; i++) {
                        numList.add(x + i, st.nextToken());
                    }
                }
            }

            sb.append("#" + t).append(" ");
            for(int i = 0; i < 10; i++) {
                sb.append(numList.get(i)).append(" ");
            }
            sb.append(System.lineSeparator());

            // 리스트 초기화
            numList.clear();
        }
        System.out.println(sb.toString());

        br.close();
    }
}