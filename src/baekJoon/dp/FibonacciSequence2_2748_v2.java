package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수2_2748_v2
 * comment : dp memoization 사용
 */
public class FibonacciSequence2_2748_v2 {
    private int getFibonacci(int n, int[] memoization) {
        System.out.println("execute, n : " + n);

        if(n == 0) return 0;
        if(n == 1) return 1;

        if(memoization[n] > 0) {
            return memoization[n];
        }

        memoization[n] = getFibonacci(n - 1, memoization) + getFibonacci(n - 2, memoization);

        return memoization[n];
    }

    public static void main(String[] args) throws IOException {
        FibonacciSequence2_2748_v2 main = new FibonacciSequence2_2748_v2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memoization = new int[n+1];

        System.out.println(main.getFibonacci(n, memoization));
    }
}
