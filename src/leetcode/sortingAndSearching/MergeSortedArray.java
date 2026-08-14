package leetcode.sortingAndSearching;

/**
 * Top Interview Questions[easy]: Sorting and Searching-Merge Sorted Array
 */
public class MergeSortedArray {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static void merge(int[] nums1, int m, int[] nums2, int n) {
            int ptr = m+n-1;
            int ptr1 = m-1;
            int ptr2 = n-1;

            while(ptr1 >= 0 && ptr2 >= 0) {
                nums1[ptr--] = nums1[ptr1] > nums2[ptr2] ? nums1[ptr1--] : nums2[ptr2--];
            }

            if(ptr2 >= 0) {
                System.arraycopy(nums2, 0, nums1, 0, ptr2+1);
            }
        }
    }
}
