/**
 * @ BJ 2857 FBI
 * @ prob : https://www.acmicpc.net/problem/2857
 */

import java.io.*;

public class BJ_2857_FBI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String code = "FBI";

        boolean isDetected = false;
        for(int i = 0; i < 5; i++) {
            String name = br.readLine();
            if(name.contains(code)) {
                isDetected = true;
                System.out.print(i + 1 + " ");
            }
        }
        if(!isDetected) {
            System.out.println("HE GOT AWAY!");
        }
        
        br.close();
    }
}