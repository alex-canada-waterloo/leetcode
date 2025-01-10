package com.naianzin.leetcode.dynamic;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        var dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 5);
        dp[0] = 0;
        Arrays.sort(coins);
        int coin;
        int i, j;
        int coinLength = coins.length - 1;
        for (i = 1; i <= amount; i++) {
            for (j = coinLength; j >= 0; j--) {
                coin = coins[j];
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        var service = new CoinChange();
        System.out.println(service.coinChange(new int[] {1,2,5}, 11) + " expected 3");
        System.out.println(service.coinChange(new int[] {2}, 3) + " expected -1");
        System.out.println(service.coinChange(new int[] {1}, 0) + " expected 0");
        System.out.println(service.coinChange(new int[] {1,2,5}, 100) + " expected 20");
        System.out.println(service.coinChange(new int[] {186,419,83,408}, 6249) + " expected 20");
    }
}
