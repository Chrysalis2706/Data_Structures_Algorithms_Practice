package Greedy_Algorithm_Problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Coin_Change {
    public static int coinChange(int[] coins, int amount) {
        int ans = 0;
        Arrays.sort(coins);

        int srt = 0;
        int end = coins.length-1;
        while (srt <= end){
            int temp = coins[srt];
            coins[srt] = coins[end];
            coins[end] = temp;
            srt += 1;
            end -= 1;
        }

        for (int i=0; i<coins.length; i++){
            if (amount >= coins[i]){
                while (amount >= coins[i]){
                    ans ++;
                    amount -= coins[i];
                }
            }
        }

        if (amount == 0) return ans;
        else return -1;

    }

    public static void main(String[] args) {
        int[] coins = {2000, 500, 100, 50, 20, 10, 5, 2, 1};
        int amount = 590;
        System.out.println(coinChange(coins, amount));

        int[] coins1 = {2};
        int amount1 = 3;
        System.out.println(coinChange(coins1, amount1));
    }
}
