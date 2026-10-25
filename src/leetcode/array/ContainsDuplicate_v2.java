package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Top Interview Questions[easy]: Contains Duplicate (Hashset 풀이)
 */
public class ContainsDuplicate_v2 {
    static void main(String[] args) {
        //
    }

    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(!set.add(n)) return true;
        }

        return false;
    }
}
