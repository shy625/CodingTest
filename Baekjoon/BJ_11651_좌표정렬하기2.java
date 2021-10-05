/**
 * @ BJ 11651 좌표 정렬하기 2
 * @ prob : https://www.acmicpc.net/problem/11651
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_11651_좌표정렬하기2 {
    public static void main(String[] args) {
    
        // inner class
        class Coordinate {
            int x;
            int y;

            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Coordinate[] positions = new Coordinate[n];
        for(int i = 0; i < n; i++) {
            positions[i] = new Coordinate(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(positions, new Comparator<Coordinate>(){
            @Override
            public int compare(Coordinate c1, Coordinate c2) {
                return c1.y != c2.y ? c1.y - c2.y : c1.x - c2.x;
            }
        });
        for (Coordinate c : positions) {
            System.out.println(c.x + " " + c.y);
        }

        sc.close();
    }
}

// class Coordinate {
//     int x;
//     int y;
//
//     public Coordinate(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }