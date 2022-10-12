class Solution {
    
    private static boolean[][] adjArray;
    
    public int solution(int n, int[][] results) {
        adjArray = new boolean[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            adjArray[winner][loser] = true;
        }
                
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] wins = new boolean[n + 1];
            boolean[] loses = new boolean[n + 1];
            
            checkWin(i, wins);
            checkLose(i, loses);
            
            int winCount = 0, loseCount = 0;
            for (int j = 1; j <= n; j++) {
                if (wins[j]) {
                    winCount++;
                }
                if (loses[j]) {
                    loseCount++;
                }
            }
            
            if (winCount + loseCount == n - 1) {
                count++;
            }
        }
        
        return count;
    }
    
    private void checkWin(int num, boolean[] isSelected) {
        for (int i = 1; i < adjArray.length; i++) {
            if (adjArray[num][i] && !isSelected[i]) {
                isSelected[i] = true;
                checkWin(i, isSelected);
            }
        }
    }
    
    private void checkLose(int num, boolean[] isSelected) {
        for (int i = 1; i < adjArray.length; i++) {
            if (adjArray[i][num] && !isSelected[i]) {
                isSelected[i] = true;
                checkLose(i, isSelected);
            }
        }
    }
    
}

// 풀이 1 - 시간초과
// 내가 이긴 선수 + 내기 진 선수 = n - 1 인 경우 본인의 순위 결정 가능
// boolean[][] 타입으로 인접행렬 만들어 선수들 간의 관계 표현
// adjArray[i][j] : i가 j 선수를 이김 & j가 i 선수에게 짐
// 승리 여부 체크 → 행을 기준으로 가로로 체크
// 패배 여부 체크 → 열을 기준으로 세로로 체크
// 각 선수에 대해 내가 이긴 선수 수와 진 선수 수를 구함
// 재귀를 이용하여 이긴 선수, 진 선수의 Set을 전달 → Set의 크기로 선수 수 구함

// 풀이 2
// 풀이 1 과 동일한데
// 재귀에서 Set을 이용해 이긴 선수, 진 선수를 전달하는 것 대신
// boolean[]을 이용하여 이겼는지 졌는지를 체크하고 숫자를 세서 선수 수 구함

// 다른 풀이 1
// 플로이드 와샬 이용
// 모든 선수 쌍에 대해서 최단거리 구하기 → 모든 선수 쌍에 대해서 갈 수 있는지 없는지 구하기
// adjArray[i][j] → k 선수를 거쳐서 i와 j 선수 간의 승리 관계를 정할 수 있는지 체크
// 플로이드 와샬을 이용해 모든 선수 쌍에 대해 승리 관계를 완성한 뒤, 이긴 선수 & 진 선수 수를 체크
// https://nahwasa.com/85
// https://gom20.tistory.com/178
// https://school.programmers.co.kr/learn/courses/30/lessons/49191/solution_groups?language=java&type=my