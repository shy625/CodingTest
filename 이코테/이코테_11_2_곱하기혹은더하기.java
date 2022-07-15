/**
 * 이코테 11-2 곱하기 혹은 더하기
 * @ prob : 
 * @ level : 
 */

import java.io.*;

public class 이코테_11_2_곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            int num = S.charAt(i) - '0';
            if (num <= 1 || result <= 1) {      // 숫자가 0 또는 1이면 더하기가 유리
                result += num;
            } else {    // 그 외의 경우에는 곱하기가 유리
                result *= num;
            }
        }

        System.out.println(result);

        br.close();
    }
}
