import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_곰곰컵_C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] foods = br.readLine().toCharArray();
        int chickenCnt = 0, otherCnt = 0;

        for (int i = 0; i < N; i++) {
            if (foods[i] == 'C') {
                chickenCnt++;
            } else {
                otherCnt++;
            }
        }
        int stream = chickenCnt / (otherCnt + 1);
        if (chickenCnt % (otherCnt + 1) > 0) {
            stream++;
        }

        System.out.println(stream);

        br.close();
    }   
}
