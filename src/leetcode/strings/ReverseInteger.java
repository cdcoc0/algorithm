package leetcode.strings;

/**
 * Top Interview Questions[easy]: Strings-Reverse Integer
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution.reverse(-2147483648);
    }

    static class Solution {
        static int reverse(int x) {
            int result = 0;
            while(Math.abs(x) > 0) {
                int last = x % 10;
                x /= 10;

                if(Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < last)) return 0;
                if(Integer.MIN_VALUE / 10 > result || (Integer.MIN_VALUE / 10 == result && Integer.MIN_VALUE % 10 > last)) return 0;

                result = result * 10 + last;
            }

            return result;
        }
    }
}
