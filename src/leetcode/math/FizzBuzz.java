package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Top Interview Questions[easy]: Fizz Buzz
 */
public class FizzBuzz {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static List<String> fizzBuzz(int n) {
            final String FIZZ = "Fizz";
            final String BUZZ = "Buzz";

            List<String> result = new ArrayList<>(n);
            for(int i = 1; i <= n; i++) {
                String tmp = "";
                if(i % 3 == 0) tmp += FIZZ;
                if(i % 5 == 0) tmp += BUZZ;
                if(tmp.isEmpty()) tmp = String.valueOf(i);
                result.add(tmp);
            }

            return result;
        }
    }
}
