package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1,2,3 더하기_9095
 */
public class Adding123 {
    private String getAdding123Counts(int n, int[] nums) {
        StringBuilder sb = new StringBuilder();
        int[] memoization = new int[12];

        // 1 2 4 7 13 24 44

        memoization[0]=1;
        memoization[1]=1;
        memoization[2]=2;

        for(int i = 3; i <= 11; i++) {
            memoization[i] = memoization[i-1] + memoization[i-2] + memoization[i-3];
        }

        for(int i = 0 ; i < n; i++) {
            sb.append(memoization[nums[i]]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Adding123 main = new Adding123();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.getAdding123Counts(n, nums));
    }
}
