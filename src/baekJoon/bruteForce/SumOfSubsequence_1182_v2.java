package baekJoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 부분수열의 합_1182
 * comment : 메모리 40000KB,,, 메모리 빌런의 코드
 */
public class SumOfSubsequence_1182_v2 {
    private void getCases(int[] sequence, int N, int S) {
        Deque<int[]> deque = new ArrayDeque<>();
        int count = 0;

        deque.push(new int[]{0, -1});  // sum, index

        while(!deque.isEmpty()) {
            int[] tmp = deque.pop();
            int sum = tmp[0];
            int idx = tmp[1];

            if(sum == S) count++;

            for(int j = idx+1; j < N; j++) {
                deque.push(new int[]{sum + sequence[j], j});
            }
        }

        if(S == 0) count--;

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        SumOfSubsequence_1182_v2 main = new SumOfSubsequence_1182_v2();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);

        String[] numbers =  br.readLine().split(" ");
        int[] sequence = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();

        main.getCases(sequence, N, S);
    }
}
