/**
 * @ BJ 1408 24
 * @ prob : https://www.acmicpc.net/problem/1408
 */

import java.util.Scanner;

public class BJ_1408 {
    public static void main(String[] args) {
        final int HOUR_2_SECOND = 3600;
        final int MINUTE_2_SECOND = 60;

        Scanner sc = new Scanner(System.in);

        String now = sc.nextLine(); //  현재 시각
        String start = sc.nextLine();   //  임무 시작 시각

        String[] nowArr = now.split(":");
        String[] startArr = start.split(":");
        
        //  초로 변환
        int nowSec = Integer.valueOf(nowArr[0]) * HOUR_2_SECOND + Integer.valueOf(nowArr[1]) * MINUTE_2_SECOND + Integer.valueOf(nowArr[2]);
        int startSec = Integer.valueOf(startArr[0]) * HOUR_2_SECOND + Integer.valueOf(startArr[1]) * MINUTE_2_SECOND + Integer.valueOf(startArr[2]);

        //  임무 완료 시각 = 임무 시작 시각 + 24h -> 임무 시작 시각과 동일
        int remainSec = 0;
        if(startSec > nowSec) { // 임무 시작 후 자정이 지난 경우
            remainSec = startSec - nowSec;
        } else {    //  임무 시작 후 자정이 지나지 않은 경우
            remainSec = 24 * HOUR_2_SECOND - (nowSec - startSec);
        }

        System.out.printf("%02d:%02d:%02d", remainSec/HOUR_2_SECOND, (remainSec%HOUR_2_SECOND)/MINUTE_2_SECOND, remainSec%MINUTE_2_SECOND);
    }
}