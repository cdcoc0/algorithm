package leetcode.array;

/**
 * Top Interview Questions[easy]: Array-Rotate Array
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        solution.rotate2(nums, k);
    }

    static class solution {
        // Time Limit Exceeded
        static void rotate1(int[] nums, int k) {
            while(k-- > 0) {
                for(int i = nums.length - 2; i >= 0; i--) {
                    swap(nums, i, i+1);
                }
            }
        }

        static void swap(int[] nums, int idx1, int idx2) {
            int tmp = nums[idx1];
            nums[idx1] = nums[idx2];
            nums[idx2] = tmp;
        }

        static void reverse(int[] nums, int start, int end) {
            while(start < end) {
                swap(nums, start++, end--);
            }
        }

        static void rotate2(int[] nums, int k) {
            k = k % nums.length;

            if(k <= 0) return;

            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
        }
    }
}
