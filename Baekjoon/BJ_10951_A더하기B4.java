/**
 * @ BJ 10951 A+B - 4
 * @ prob : https://www.acmicpc.net/problem/10951
 */

import java.util.Scanner;

public class BJ_10951_A더하기B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String[] inputs = sc.nextLine().split(" ");
            System.out.println(Integer.valueOf(inputs[0]) + Integer.valueOf(inputs[1]));
        }

        sc.close();
    }
}

// 다른 풀이 1
// sc.hasNextInt(), sc.nextInt()를 이용하여 int로 바로 받기

// while(sc.hasNextInt()) {
//     System.out.println(sc.nextInt() + sc.nextInt());
// }