package leetcode.sortingAndSearching;

/**
 * Top Interview Questions[easy]: Sorting and Searching-First Bad Version
 */
public class FirstBadVersion {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int firstBadVersion(int n) {
            int ptr1 = 1;
            int ptr2 = n;

            while(ptr1 <= ptr2) {
                int mid = ptr1 + (ptr2 - ptr1) / 2;
                if(isBadVersion(mid)) ptr2 = mid - 1;
                else ptr1 = mid + 1;
            }

            return ptr1;
        }

        static boolean isBadVersion(int version) {
            return true;
        }
    }
}
