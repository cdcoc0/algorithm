package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 부분수열의 합_1182
 * comment : recursive로 성능 개선
 */
public class SumOfSubsequence_1182 {
    private int[] sequence;
    private int N;
    private int S;
    private int count = 0;

    private void dfs(int sum, int depth) {
        if(depth == N) {
            if(sum == S) {
                count++;
            }
            return;
        }

        dfs(sum + sequence[depth], depth+1);
        dfs(sum, depth+1);
    }

    private void getCases() {
        dfs(0, 0);

        if(S == 0) count--;

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        SumOfSubsequence_1182 main = new SumOfSubsequence_1182();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        main.N = Integer.parseInt(split[0]);
        main.S = Integer.parseInt(split[1]);

        String[] numbers =  br.readLine().split(" ");
        main.sequence = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();

        main.getCases();
    }
}
