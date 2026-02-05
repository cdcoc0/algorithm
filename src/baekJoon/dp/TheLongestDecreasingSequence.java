package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 가장 긴 감소하는 수열_11722
 */
public class TheLongestDecreasingSequence {
    private int getSequenceLength(int N, int[] arrN) {
        int[] memoization = new int[N];
        int max = 1;

        for(int i = 0; i < N; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arrN[j] > arrN[i]) {
                    memoization[i] = Math.max(memoization[i], memoization[j]+1);
                    if(memoization[j] == max) {
                        max++;
                        break;
                    }
                }
            }

            if(memoization[i] == 0) memoization[i] = 1;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        TheLongestDecreasingSequence main = new TheLongestDecreasingSequence();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] split =  br.readLine().split(" ");
        int[] arrN = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();

        System.out.println(main.getSequenceLength(N, arrN));
    }
}
