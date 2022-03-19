/**
 * BJ 2884 알람 시계
 * @ prob : https://www.acmicpc.net/problem/2884
 * @ level : B3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2884_알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minute = time2Minute(new int[]{H, M});
        int[] time = minute2Time(minute - 45);

        System.out.println(time[0] + " " + time[1]);
    }

    private static int time2Minute(int[] time) {
        return time[0] * 60 + time[1];
    }

    private static int[] minute2Time(int minute) {
        int[] time = new int[2];
        if(minute >= 0) {
            time[0] = minute / 60;
            time[1] = minute % 60;
        } else {
            time[0] = (1440 + minute) / 60;
            time[1] = (1440 + minute) % 60;
        }
        return time;
    }
}
// 풀이 1
// 시간 & 분을 분으로 환산하여 계산 후 다시 환산