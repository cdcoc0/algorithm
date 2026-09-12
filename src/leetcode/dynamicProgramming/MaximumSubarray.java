package leetcode.dynamicProgramming;

/**
 * Top Interview Questions[easy]: Maximum Subarray
 */
public class MaximumSubarray {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int maxSubArray(int[] nums) {
            int max = nums[0];

            for(int i = 1; i < nums.length; i++) {
                nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
                max = Math.max(max, nums[i]);
            }

            return max;
        }
    }
}
