class Solution {
    
    private int maxCount;
    
    public int solution(int k, int[][] dungeons) {
        maxCount = 0;
        goDungeon(k, dungeons, new boolean[dungeons.length], 0);
        return maxCount;
    }
    
    private void goDungeon(int energy, int[][] dungeons, boolean[] isVisited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && energy >= dungeons[i][0]) {
                isVisited[i] = true;
                goDungeon(energy - dungeons[i][1], dungeons, isVisited, count + 1);
                isVisited[i] = false;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
}

// 풀이 1
// 유저의 현재 피로도와 각 던전마다의 필요 피로도, 소모 피로도가 주어짐
// 유저가 던전을 어떻게 돌아야 최대한 많은 던전을 돌 수 있는지 확인
// 유저가 최대한으로 돌 수 있는 던전의 수는 어떤 던전들을 어떤 순서로 도는지에 따라 다름
// 던전의 개수가 8개 → 순열을 이용한 완전탐색 가능

// 다른 풀이 1
// boolean[] isVisited 배열 대신 이미 방문한 배열의 필요 피로도를 최댓값으로 변경하여 다시 방문하지 않도록 처리