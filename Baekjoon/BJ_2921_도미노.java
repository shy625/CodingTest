/**
 * @ BJ 2921 도미노
 * @ prob : https://www.acmicpc.net/problem/2921
 */

import java.util.Scanner;

public class BJ_2921_도미노 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int sum = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                sum += i + j;
            }
        }

        System.out.println(sum);
    }
}

// 다른 풀이 1
// https://unagi44.wordpress.com/2018/06/13/%EB%B0%B1%EC%A4%80-2921-%EB%8F%84%EB%AF%B8%EB%85%B8/

// 다른 풀이 2
// https://has3ong.tistory.com/537

// 다른 풀이 3
// https://blog.naver.com/PostView.nhn?blogId=ldw0811&logNo=221774412236

// 기타 풀이 추가