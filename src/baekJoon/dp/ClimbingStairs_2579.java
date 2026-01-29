package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기_2579
 */
public class ClimbingStairs_2579 {
    private int getMaxScore(int n, int[] scores) {
        if(n <= 1) return scores[1];

        int[] memoization = new int[n+1];

        memoization[1] = scores[1];
        memoization[2] = scores[1]+scores[2];
        for(int i = 3; i <= n; i++) {
            //i-2의 최대값, i-1의 최대, 차대값 비교
            memoization[i] = scores[i] + Math.max(memoization[i-2], memoization[i-3]+scores[i-1]);
        }

        return memoization[n];
    }

    public static void main(String[] args) throws IOException {
        ClimbingStairs_2579 main = new ClimbingStairs_2579();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n+1];
        for(int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.getMaxScore(n, score));
    }
}

