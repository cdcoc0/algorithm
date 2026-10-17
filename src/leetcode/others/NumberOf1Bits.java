package leetcode.others;

/**
 * Top Interview Questions[easy]: Number of 1 Bits
 */
public class NumberOf1Bits {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int hammingWeight(int n) {
            int count = 0;
            while(n != 0) {
                n &= (n-1); // 비트연산자 (가장 오른쪽의 1을 제거)
                count++;
            }

            return count;
//            return Integer.bitCount(n);
        }
    }
}
