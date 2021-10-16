/**
 * @ BJ 2484 주사위 네개
 * @ prob : https://www.acmicpc.net/problem/2484
 */

import java.util.Scanner;

public class BJ_2484_주사위네개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int maxReward = 0;
        for(int i = 0; i < n; i++) {
            int[] arr = {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            maxReward = Math.max(maxReward, calculateReward(arr));
        }
        System.out.println(maxReward);

        sc.close();
    }
    
    static int calculateReward(int[] arr) {
        int[] diceNum = new int[7];
        int maxCount = 0, freqNum = 0;
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            diceNum[arr[i]]++;
            if(diceNum[arr[i]] > maxCount) {
                maxCount = diceNum[arr[i]];
                freqNum = arr[i];
            }
        }
        outer :
        switch(maxCount) {
            case 4 :
                result = 50000 + freqNum * 5000;
                break;
            case 3 :
                result = 10000 + freqNum * 1000;
                break;
            case 2 :
                for(int i = 1; i < diceNum.length; i++) {
                    if((i != freqNum) && (diceNum[i] == 2)) {
                        result = 2000 + freqNum * 500 + i * 500;
                        break outer;
                    }
                }
                result = 1000 + freqNum * 100;
                break;
            case 1 :
                for(int i = diceNum.length-1; i > 0; i--) {
                    if(diceNum[i] == 1) {
                        result = i * 100;
                        break outer;
                    }
                }
        }
        return result;
    }
}