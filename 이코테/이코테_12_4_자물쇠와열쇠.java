/**
 * 이코테 12-4 자물쇠와 열쇠
 * @ prob : https://school.programmers.co.kr/learn/courses/30/lessons/60059
 * @ level : 3
 */

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        int[][] newLock = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[n + i][n + j] = lock[i][j];
            }
        }
        
        for (int k = 0; k < 4; k++) {
            key = rotateKey(key);
            for (int i = 1; i < 2 * n; i++) {
                for (int j = 1; j < 2 * n; j++) {
                    for (int r = 0; r < m; r++) {
                        for (int c = 0; c < m; c++) {
                            newLock[i + r][j + c] += key[r][c];
                        }
                    }
                    if (checkLockOpen(newLock)) {
                        return true;
                    }
                    for (int r = 0; r < m; r++) {
                        for (int c = 0; c < m; c++) {
                            newLock[i + r][j + c] -= key[r][c];
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private int[][] rotateKey(int[][] key) {
        int m = key.length;
        int[][] tmp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp[j][m - 1 - i] = key[i][j];
            }
        }
        return tmp;
    }
    
    private boolean checkLockOpen(int[][] newLock) {
        int n = newLock.length / 3;
        boolean result = true;
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if (newLock[i][j] != 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}

// 풀이 1
// 주어진 범위 안에서는 완전탐색 가능
// 열쇠를 회전 & 이동시켜 자물쇠에 맞는지 확인
// 풀이를 쉽게하기 위해 자물쇠 배열을 확장시켜 사용