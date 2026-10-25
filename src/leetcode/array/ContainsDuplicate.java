package leetcode.array;

import java.util.Arrays;

/**
 * Top Interview Questions[easy]: Contains Duplicate
 */
public class ContainsDuplicate {
    static void main(String[] args) {
        //
    }

    static boolean containsDuplicate(int[] nums) {
        long distinct = Arrays.stream(nums).distinct().count();

        return distinct != nums.length;
    }
}
