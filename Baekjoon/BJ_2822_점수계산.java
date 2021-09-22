/**
 * @ BJ 2822 점수 계산
 * @ prob : https://www.acmicpc.net/problem/2822
 */

import java.util.*;

public class BJ_2822_점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int[] scores = new int[8];
        for(int i = 0; i < 8; i++) {
            scores[i] = sc.nextInt();
        }

        Integer[] sortedScores = Arrays.stream(scores.clone()).boxed().toArray(Integer[]::new); // int[] -> Integer[] 변환
        Arrays.sort(sortedScores, Collections.reverseOrder());  // 내림차순 정렬
        for(int i = 0; i < 5; i++) {
            sum += sortedScores[i];
        }
        System.out.println(sum);
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 5; j++) {
                if(scores[i] == sortedScores[j]) {
                    System.out.print(i+1 + " ");
                }
            }
        }

        sc.close();
    }
}

// 다른 풀이 1
// 같은 로직, 더 간단한 풀이

// int[] scores = new int[8];
// int[] sortedScores = new int[8];
// int sum = 0;
// 
// for(int i = 0; i < scores.length; i++) {
//     scores[i] = sc.nextInt();
//     sortedScores[i] = scores[i];
// }
// 
// Arrays.sort(sortedScores);
// for(int i = sortedScores.length-1; i >= 3; i--) {
//     sum += sortedScores[i];
// }
// System.out.println(sum);
// 
// for(int i = 0; i < scores.length; i++) {
//     if(scores[i] >= sortedScores[3]) {
//         System.out.print(i+1 + " ");
//     }
// }

// 다른 풀이 2
// 0 ~ 150까지의 boolean 배열 생성하여 score 등장 여부, 상위 5개 포함 여부 체크
// https://www.acmicpc.net/source/16865924

// boolean[] isScoreArr = new boolean[151];
// boolean[] isAddedArr = new boolean[151];
// int[] scores = new int[8];
// int sum = 0;
// 
// for(int i = 0; i < 8; i++) {
//     scores[i] = sc.nextInt();
//     isScoreArr[scores[i]] = true;
// }
// 
// int count = 0;
// for(int i = isScoreArr.length-1; i >= 0; i--) {
//     if(count >= 5) {
//         break;
//     }
//     if(isScoreArr[i]) {
//         sum += i;
//         isAddedArr[i] = true;
//         count++;
//     }
// }
// System.out.println(sum);
// 
// for(int i = 0; i < scores.length; i++) {
//     if(isAddedArr[scores[i]]) {
//         System.out.print(i+1 + " ");
//     }
// }

// 다른 풀이 3
// Comparable을 구현한 새로운 클래스 생성하여 사용
// https://www.acmicpc.net/source/7959874

// public static void main(String[] args) {
//     class Score implements Comparable{
//         int idx;
//         int score;
// 
//         Score(int idx, int score) {
//             this.idx = idx;
//             this.score = score;
//         }
// 
//         @Override
//         public int compareTo(Object o) {
//             // TODO Auto-generated method stub
//             if(o instanceof Score) {
//                 Score s = (Score)o;
//                 return this.score - s.score;
//             }
//             return 0;
//         }
//     }
// 
//     Scanner sc = new Scanner(System.in);
// 
//     Score[] scores = new Score[8];
//     int sum = 0;
// 
//     for(int i = 0; i < 8; i++) {
//         scores[i] = new Score(i+1, sc.nextInt());
//     }
// 
//     Arrays.sort(scores);
// 
//     List<Integer> indexs = new ArrayList<>();
//     for(int i = scores.length-1; i >= 3; i--) {
//         sum += scores[i].score;
//         indexs.add(scores[i].idx);
//     }
//     System.out.println(sum);
// 
//     Collections.sort(indexs);
//     for(int i : indexs) {
//         System.out.print(i + " ");
//     }
// 
//     sc.close();
// }

// 다른 풀이 4
// 배열 2개 대신 [8][2] 짜리 2차원 배열 생성
// https://www.acmicpc.net/source/17876932

// 다른 풀이 5
// i번째로 입력된 값의 순위(내림차순 정렬 시 순위)를 값으로 가지는 배열 생성
// https://www.acmicpc.net/source/19831012
