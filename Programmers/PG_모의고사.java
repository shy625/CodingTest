/**
 * PG 모의고사
 * @ prob : https://programmers.co.kr/learn/courses/30/lessons/42840
 * @ level : 1
 */

class Solution {
    public int[] solution(int[] answers) {
        String[] pattern = new String[3];
        pattern[0] = "12345";
        pattern[1] = "21232425";
        pattern[2] = "3311224455";
        
        int[] patternIdx = new int[3];
        int[] answerCount = new int[3];
        int max = 0;
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                int pick = pattern[j].charAt(patternIdx[j]) - '0';
                if (answers[i] == pick) {
                    max = Math.max(max, ++answerCount[j]);
                }
                patternIdx[j] = (patternIdx[j] + 1) % pattern[j].length();
            }
        }
        
        int maxCount = 0;
        for (int i = 0; i < 3; i++) {
            if (answerCount[i] == max) {
                maxCount++;
            }
        }
        
        int[] result = new int[maxCount];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (answerCount[i] == max) {
                result[idx++] = i + 1;
            }
        }
        
        return result;
    }
}

// 풀이 1
// 패턴의 길이가 서로 다르기 때문에 그냥 int형 2차원 배열 대신 문자열 배열을 이용해 1, 2, 3 수험자의 패턴을 저장
// 패턴에 따라 답을 맞추고 그 중 최댓값 구함
// 최댓값을 가지는 수험자 수를 구하고 그 크기를 가지는 배열 선언하여 수험자 번호 저장 후 반환
