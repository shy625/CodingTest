/**
 * @ BJ 2581 소수
 * @ prob : https://www.acmicpc.net/problem/2581
 */

import java.util.Scanner;

public class BJ_2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int[] arr = isPrime(initArray(n));  // n까지의 수에 대해 소수 여부가 체크된 배열 생성

        int min = -1;
        for(int i = m; i < arr.length; i++) {   // 소수 중 최솟값 저장
            if(arr[i] != -1) {
                min = arr[i];
                break;
            }
        }
        if(min > 0) {   // 소수가 있으면
            int sum = 0;
            for(int i = min; i < arr.length; i++) { // 소수의 합 저장
                if(arr[i] != -1) {
                    sum += arr[i];
                }
            }
            System.out.println(sum);
            System.out.println(min);
        } else {    // 소수가 없으면
            System.out.println(min);
        }
    }

    // 길이가 n인 배열 생성 및 index 값으로 초기화
    static int[] initArray(int n) {
        int[] arr = new int[n+1];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        return arr;
    }

    // 배열에 담긴 수에 대해 소수가 아니면 -1로 변경
    static int[] isPrime(int[] arr) {
        arr[0] = -1;
        arr[1] = -1;
        for(int i = 2; i <= (int)Math.sqrt(arr.length-1); i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] % i == 0) {
                    arr[j] = -1;
                }
            }
        }

        return arr;
    }
}

// 다른 풀이 1
// m부터 n까지 모든 수에 대해서 일일이 소수 여부 확인

// int sum = 0, min = 0;
// outer :
// for(int i = m; i <= n; i++) {   // m부터 n까지
//     for(int j = 2; j <= (int)Math.sqrt(i); j++) {   // 소수 체크
//         if(i % j == 0) {
//             continue outer; // 소수가 아니면(나누어 떨어지면) 다음으로 스킵
//         }
//     }
//     if(i < 2) { // 0과 1이면 스킵
//         continue;
//     } else {    // 소수이면 아래 실행
//         if(sum == 0) {
//             min = i;
//         }
//         sum += i;
//     }
// }
// System.out.println(sum == 0 ? -1 : sum + "\n" + min);