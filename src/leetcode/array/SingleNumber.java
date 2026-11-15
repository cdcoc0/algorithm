package leetcode.array;

/**
 * Top Interview Questions[easy]: Array-Single Number
 * (비트연산자 사용)
 */
public class SingleNumber {
    static void main(String[] args) {
        //
    }

    class Solution {
        int singleNumber(int[] nums) {
            int result = 0;
            for(int num : nums) {
                result ^= num;
            }

            return result;
        }
    }
}
