/**
 * PG 카펫
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/42842
 * @ level : 2
 */

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int x = 1; x <= brown + yellow; x++) {
            int y = 2 + brown / 2 - x;
            if (x * y == brown + yellow) {
                if (x >= y) {
                    answer[0] = x;
                    answer[1] = y;
                } else {
                    answer[0] = y;
                    answer[1] = x;
                }
                break;
            }
        }
        
        return answer;
    }
}

// 풀이 1
// 카펫의 세로 또는 가로 길이를 x, 다른 길이를 y라고 할 때,
//   x * y = brown + yellow
//   x + y = brown / 2 + 2
// 라는 연립방정식을 세울 수 있다.
// 이를 이용하여 x 또는 y에 값을 차례로 대입해보며 조건에 맞는 값을 찾을 수 있다.

// 다른 풀이 1
// 위에서 세운 연립방정식을 바탕으로 근의 공식을 사용하여 조건을 만족하는 두 해를 구하면 각각이 가로, 세로의 길이이다.