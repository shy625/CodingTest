/**
 * @ BJ 5543 상근날드
 * @ prob : https://www.acmicpc.net/problem/5543
 */

import java.util.*;

public class BJ_5543_상근날드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] burgers = new int[3];
        int[] drinks = new int[2];

        for(int i = 0; i < burgers.length; i++) {
            burgers[i] = sc.nextInt();
        }
        for(int i = 0; i < drinks.length; i++) {
            drinks[i] = sc.nextInt();
        }
        Arrays.sort(burgers);
        Arrays.sort(drinks);

        int setPrice = burgers[0] + drinks[0] - 50;
        System.out.println(setPrice);

        sc.close();
    }
}

// 다른 풀이 1
// 최댓값, 최솟값만 구해서 계산 - Math.max, Math.min 이용

// int minBurgerPrice = Math.min(Math.min(sc.nextInt(), sc.nextInt()), sc.nextInt());
// int minDrinkPrice = Math.min(sc.nextInt(), sc.nextInt());
// int minSetPrice = minBurgerPrice + minDrinkPrice - 50;
// System.out.println(minSetPrice);