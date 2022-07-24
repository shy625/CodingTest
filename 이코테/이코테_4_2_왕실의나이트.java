/**
 * 이코테 4-2 왕실의 나이트
 * @ prob : 
 * @ level : 
 */

import java.io.*;

public class 이코테_4_2_왕실의나이트 {

    static int[] dr = { -2, -2, -1, 1, 2, 2, 1, -1 };
    static int[] dc = { -1, 1, 2, 2, 1, -1, -2, -2 };
    // static int[][] steps = {
    //         { -2, -1 },
    //         { -2, 1 },
    //         { -1, 2 },
    //         { 1, 2 },
    //         { 2, 1 },
    //         { 2, -1 },
    //         { 1, -2 },
    //         { -1, -2 }
    //     };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int r = input.charAt(1) - '1';
        int c = input.charAt(0) - 'a';

        int count = 0;
        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            // int nr = r + steps[d][0];
            // int nc = c + steps[d][1];
            if (isInOfBound(nr, nc)) {
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }

    private static boolean isInOfBound(int r, int c) {
        return 0 <= r && r < 8 && 0 <= c && c < 8;
    }
}
