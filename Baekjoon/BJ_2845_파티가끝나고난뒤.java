/**
 * @ BJ 2845 파티가 끝나고 난 뒤
 * @ prob : https://www.acmicpc.net/problem/2845
 */

import java.util.Scanner;

public class BJ_2845_파티가끝나고난뒤 {
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);

        int peopleNumPerArea = sc.nextInt(), area = sc.nextInt();
        int realPeopleNum = peopleNumPerArea * area;

        for(int i = 0; i < 5; i++) {
            System.out.print(sc.nextInt() - realPeopleNum + " ");
        }

        sc.close();
    }
}