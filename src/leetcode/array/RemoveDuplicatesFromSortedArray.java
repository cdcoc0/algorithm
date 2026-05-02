package leetcode.array;

/**
 * Top Interview Questions[easy]: Array-Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {1, 1, 2};
        Solution.removeDuplicates(nums);
    }

    static class Solution {
        static int removeDuplicates(int[] nums) {
            int ptr = 1;
            for(int i = 1; i < nums.length; i++) {
                if(nums[i] > nums[ptr-1]) nums[ptr++] = nums[i];
            }


            return ptr;
        }
    }
}
