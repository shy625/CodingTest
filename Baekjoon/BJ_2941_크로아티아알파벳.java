/**
 * BJ 2941 크로아티아 알파벳
 * @ prob : https://www.acmicpc.net/problem/2941
 * @ level : S5
 * @ blog : 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941_크로아티아알파벳 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int count = 0;
        int i = input.length() - 1;     // 문자열 뒤에서부터 확인
        while(i >= 0) {
            count++;

            char ch = input.charAt(i);
            if(ch == '-') {     // - 가 나오면 앞으로 2칸 이동
                i -= 2;
                continue;
            } else if(ch == '=') {  // = 나오고
                if(i - 2 >= 0 && input.substring(i-2, i).equals("dz")) {    // 앞의 문자가 dz이면 3칸 이동
                    i -= 3;
                    continue;
                } else {    // 아니면 2칸 이동
                    i -= 2;
                    continue;
                }
            } else if(ch == 'j') {  // j가 나오고
                if(i - 1 >= 0 && (input.charAt(i-1) == 'l' || input.charAt(i-1) == 'n')) {  // 바로 앞이 l이나 n이면 2칸 이동
                    i -= 2;
                    continue;
                }
            }
            i--;    // 그 외에는 앞으로 1칸씩 이동
        }

        System.out.println(count);

        br.close();
    }
}