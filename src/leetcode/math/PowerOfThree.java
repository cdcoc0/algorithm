package leetcode.math;

/**
 * Top Interview Questions[easy]: Power of Three
 */
public class PowerOfThree {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static boolean isPowerOfThree(int n) {
            return n > 0 && Math.pow(3, 19) % n == 0;
        }
    }
}
