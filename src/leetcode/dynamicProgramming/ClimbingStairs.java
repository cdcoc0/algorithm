package leetcode.dynamicProgramming;

/**
 * Top Interview Questions[easy]: Dynamic Programming-Climbing Stairs
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution.climbStairs(38);
    }

    static class Solution {
        static int recursive(int n, int[] memoization) {
            if(n < 0) return 0;
            if(n == 0) return 1;

            if(memoization[n] != 0) return memoization[n];

            memoization[n] = recursive(n-1, memoization) + recursive(n-2, memoization);
            return memoization[n];
        }
        static int climbStairs(int n) {
            int[] memoization = new int[n+1];
            return recursive(n, memoization);
        }
    }
}
