package leetcode.others;

/**
 * Top Interview Questions[easy]: Hamming Distance
 */
public class HammingDistance {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y); // xor
        }
    }
}
