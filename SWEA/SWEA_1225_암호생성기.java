/**
 * SWEA 1225 암호생성기
 * @ prob : https://bit.ly/3HEc9o6
 * @ level : D3
 * @ Blog : 
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t = 1; t <= 10; t++) {
            sc.nextInt();

            Queue<Integer> q = new LinkedList<>();

            // Queue에 차례대로 넣기
            for(int i = 0; i < 8; i++) {
                q.offer(sc.nextInt());
            }

            outer :
            while(true) {
                // 1 ~ 5 를 차례대로 빼기 반복
                for(int i = 1; i <= 5; i++) {
                    int num = q.poll();
                    num = num - i > 0 ? num - i : 0;    // 0 이하는 0으로 설정
                    q.offer(num);
                    if(num <= 0) {  // 0인 숫자가 생기면 종료
                        break outer;
                    }
                }
            }

            System.out.print("#" + t + " ");
            for(int i = 0; i < 8; i++) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

// 다른 방법 1
// 1 ~ 5로 반복되는 빼는 숫자를 반복문이 아닌 % 연산을 이용
// https://swexpertacademy.com/main/talk/solvingClub/problemSolverCodeDetail.do

// while(true) {
//     int temp = q.poll() - minus;
//     if(temp <= 0) {
//         q.add(0);
//         break;
//     }
//     q.add(temp);
//     minus = minus % 5 + 1;
// }

// 다른 방법 2
// Queue 대신 배열을 이용해 푸는 방법