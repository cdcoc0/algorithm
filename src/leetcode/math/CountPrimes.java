package leetcode.math;

/**
 * Top Interview Questions[easy]: Count Primes
 */
public class CountPrimes {
    static void main(String[] args) {
        //
    }

    static class Solution {
        static int countPrimes(int n) {
            if(n <= 2) return 0;

            boolean[] isPrime = new boolean[n];
            int count = n-1;

            for(int i = 2; i * i < n; i++) {
                if(isPrime[i]) continue;
                for(int j = i * i; j < n; j += i) {
                    if(isPrime[j]) continue;

                    isPrime[j] = true;
                    count--;
                }
            }

            return count;
        }
    }
}
