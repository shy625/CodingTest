class Solution {
    
    private static String[] set = {" ", "A", "E", "I", "O", "U"};
    private static int count;
    private static boolean flag;
    
    public int solution(String word) {
        count = 0;
        flag = false;
        makeWord(word, "", 0);
        return count - 1;
    }
    
    private void makeWord(String target, String word, int n) {
        if (flag) {
            return;
        }
        if ((n > 0 && word.charAt(n - 1) == ' ') || word.length() == 5) {
            count++;
            if (target.equals(word.trim())) {
                flag = true;
            }
            return;
        }
        for (int i = 0; i < set.length; i++) {
            makeWord(target, word + set[i], n + 1);
        }
    }
}

// 풀이 1
// 모음의 개수 5개, 단어의 길이 최대 5 → 약 5^5 경우의 수(단어 길이가 5보다 작은 경우도 있으므로 더 큼)
// 따라서 완전탐색으로 풀이 가능
// 중복 순열을 이용해 주어진 모음으로 만들 수 있는 모든 단어 생성 후 찾는 단어가 나오면 그때의 개수를 출력

// 다른 풀이 1
// 풀이 1과 접근은 비슷하지만 구현이 약간 다른 풀이
// 풀이 1은 찾는 단어가 나오면 바로 종료했으나
// 해당 풀이는 나올 수 있는 모든 단어를 다 구해서 리스트에 넣고 찾는 단어의 리스트 인덱스를 출력
// https://rovictory.tistory.com/112

// 다른 풀이 2
// 규칙을 이용한 풀이
// https://seongho96.tistory.com/50