package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수2_2748
 */
public class FibonacciSequence2_2748 {
    private long getFibonacci(long a, long b, int n, int limit) {
        if(n == limit) return a;
        return this.getFibonacci(a+b, a, n+1, limit);
    }

    public static void main(String[] args) throws IOException {
        FibonacciSequence2_2748 main = new FibonacciSequence2_2748();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(main.getFibonacci(1, 0, 1, n));
    }
}
