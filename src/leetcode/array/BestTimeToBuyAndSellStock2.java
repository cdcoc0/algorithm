package leetcode.array;

/**
 * Top Interview Questions[easy]: Array-BestTimeToBuyAndSellStock2
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution.solution(prices);
    }

    static class Solution {
        static public int solution(int[] prices) {
            int profit = 0;
            for(int i = 0; i < prices.length-1; i++) {
                if(prices[i] < prices[i+1]) {
                    profit += prices[i+1] - prices[i];
                }
            }
            return profit;
        }
    }
}
