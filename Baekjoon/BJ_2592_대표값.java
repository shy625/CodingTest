/**
 * @ BJ 2592 대표값
 * @ prob : https://www.acmicpc.net/problem/2592
 */

import java.util.Scanner;

public class BJ_2592_대표값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0, pos = 0;
        Number[] freq = new Number[10];
        Number max = new Number();

        outer :
        for(int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            sum += num;
            for(int j = 0; j < pos; j++) {
                if(freq[j].number == num) {
                    freq[j].count++;
                    continue outer;
                }
            }
            freq[pos++] = new Number(num, 1);
        }

        for(int i = 0; i < pos; i++) {
            if(freq[i].count > max.count) {
                max = freq[i];
            }
        }

        System.out.println(sum / 10);
        System.out.println(max.number);

        sc.close();
    }
}

class Number {
    int number = 0;
    int count = 0;

    Number() {
        this(0, 0);
    }

    Number(int number, int count) {
        this.number = number;
        this.count = count;
    }
}

// 다른 풀이 1
// 문제의 제약조건을 이용 -> 통으로 빈도 수 체크용 배열 생성하여 풀이
// 제약조건 : 주어지는 자연수는 1000보다 작은 10의 배수 -> 길이 100인 int 배열 생성

// public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//
//     int sum = 0, max = 0;
//     int[] freq = new int[100];
//
//     for(int i = 0; i < 10; i++) {
//         int num = sc.nextInt();
//         sum += num;
//         freq[num/10]++;
//         if(freq[num/10] > freq[max/10]) {
//             max = num;
//         }
//     }
//     System.out.println(sum / 10);
//     System.out.println(max);
//
//     sc.close();
// }