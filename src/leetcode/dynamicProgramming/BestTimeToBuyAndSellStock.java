package leetcode.dynamicProgramming;

/**
 * Top Interview Questions[easy]: Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {
    static void main(String[] args) {
        //
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int profit = 0;

            for (int price : prices) {
                min = Math.min(price, min);
                profit = Math.max(profit, price - min);
            }

            return profit;
        }
    }
}
