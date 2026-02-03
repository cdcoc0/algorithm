package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2xn 타일링_11726
 */
public class x2nTiling_11726 {
    private int getNumsOfcases_fibonacci(int n, int[] memoization) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memoization[n] == 0) memoization[n] = (getNumsOfcases_fibonacci(n-1, memoization) + getNumsOfcases_fibonacci(n-2, memoization)) % 10007;

        return memoization[n];
    }

    private int getNumsOfcases(int n) {
        int[] memoization = new  int[Math.max(n+1, 3)];
        memoization[1] = 1;
        memoization[2] = 2;

        for(int i = 3; i <= n; i++) {
            memoization[i] = (memoization[i-1] + memoization[i-2])%10007;
        }

        return memoization[n];
    }

    public static void main(String[] args) throws IOException {
        x2nTiling_11726 main = new x2nTiling_11726();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        System.out.println(main.getNumsOfcases(n, new int[n+1]));
        System.out.println(main.getNumsOfcases(n));
    }
}
