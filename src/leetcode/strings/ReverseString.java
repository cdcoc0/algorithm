package leetcode.strings;

/**
 * Top Interview Questions[easy]: Strings-Reverse String
 */
public class ReverseString {
    public static void main(String[] args) {
        //
    }

    static class Solution {
        static void swap(char[] s, int idx1, int idx2) {
            char tmp = s[idx1];
            s[idx1] = s[idx2];
            s[idx2] = tmp;
        }

        static void reverseString(char[] s) {
            int start = 0;
            int end = s.length - 1;
            while(start < end) {
                swap(s, start++, end--);
            }
        }
    }
}
