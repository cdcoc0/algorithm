package baekJoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* N과 M (1) */
public class NAndM_1 {
    StringBuilder sb;
    boolean[] visited;
    int[] nums;
    int N;
    int M;

    private void permutation(int lvl) {
        if(lvl == M) {
//            System.out.println(Arrays.toString(nums).replaceAll("[\\[,\\]]", ""));
            for(int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for(int i = 0; i < N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    nums[lvl] = i + 1;
                    permutation(lvl + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private void execute() {
        sb = new StringBuilder();
        visited = new boolean[N];
        nums = new int[M];

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            nums[0] = i + 1;
            permutation(1);
            visited[i] = false;
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        NAndM_1 main = new NAndM_1();
        main.N = Integer.parseInt(split[0]);
        main.M = Integer.parseInt(split[1]);
        main.execute();
    }
}
