/**
 * @ BJ 10833 사과
 * @ prob : https://www.acmicpc.net/problem/10833
 */

 import java.util.Scanner;

public class BJ_10833_사과 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int remainAppleSum = 0;
        for(int i = 0; i < n; i++) {
            School school = new School(sc.nextInt(), sc.nextInt());
            remainAppleSum += school.distributeApple();
        }
        System.out.println(remainAppleSum);

        sc.close();
    }
}

class School {
    int studentNum = 0;
    int appleNum = 0;

    School() {
        this(0, 0);
    }

    School(int studentNum, int appleNum) {
        this.studentNum = studentNum;
        this.appleNum = appleNum;
    }

    public int distributeApple() {
        int remainAppleNum = appleNum % studentNum;
        return remainAppleNum;
    }
}

// School class를 BJ_10833_사과 class의 내부에 선언 후,
// static method인 main 메소드 내에서 사용하고 싶다면 School class도 static으로 선언해야 함
// https://mainia.tistory.com/2675