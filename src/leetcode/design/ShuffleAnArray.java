package leetcode.design;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Top Interview Questions[easy]: Shuffle an Array
 */
public class ShuffleAnArray {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int[] nums;
        static int[] shuffles;

        Solution(int[] nums) {
            // nums도 clone으로 할당하는 게 더 방어적
            Solution.nums = nums;
            Solution.shuffles = nums.clone();
        }

        static int[] reset() {
            return nums;
        }

        static int[] shuffle() {
            // Fisher-Yates Shuffle
            for(int i = shuffles.length-1; i >= 0; i--) {
                int idx = ThreadLocalRandom.current().nextInt(i+1);
                int tmp = shuffles[i];
                shuffles[i] = shuffles[idx];
                shuffles[idx] = tmp;
            }

            return shuffles;
        }
    }
}
