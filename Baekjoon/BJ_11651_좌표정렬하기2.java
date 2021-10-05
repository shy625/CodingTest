/**
 * @ BJ 11651 좌표 정렬하기 2
 * @ prob : https://www.acmicpc.net/problem/11651
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_11651_좌표정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Coordinate[] positions = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            positions[i] = new Coordinate(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(positions, new Comparator<Coordinate>(){
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.y != o2.y ? o1.y - o2.y : o1.x - o2.x;
            }
        });
        for (Coordinate c : positions) {
            System.out.println(c.x + " " + c.y);
        }

        sc.close();
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}