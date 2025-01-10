package com.naianzin.leetcode.top_interview_150.array_string;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class BuyStocks2 {

    public int maxProfit(int[] prices) {
        var profit = 0;
        var diff = 0;
        for (var i = 0; i < prices.length - 1; i++) {

            diff = prices[i + 1] - prices[i];

            if (diff > 0) {
                profit += diff;
            }

        }

        return profit;
    }

    public static void main(String[] args) {

        var buyStocks2 = new BuyStocks2();

        var prices1 = new int[] {7, 1, 5, 3, 6, 4};
        var profit1 = buyStocks2.maxProfit(prices1);
        System.out.println(profit1);
    }

}
