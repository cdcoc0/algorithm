package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/* 숨바꼭질4 */
public class HideAndSeek4 {
    private void execute(int N, int K) {
        int[] prev = new int[100001];
        int[] time = new int[100001];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        time[N] = 0;

        while(!queue.isEmpty()) {
            Integer tmp = queue.poll();

            if(tmp == K) {
                StringBuilder sb = new StringBuilder();
                int n = K;
                sb.append(n);

                for(int i = 1; i <= time[tmp]; i++) {
                    sb.insert(0, prev[n] + " ");
                    n = prev[n];
                }

                System.out.println(time[K]);
                System.out.println(sb);

                return;
            }

            for(int move : new int[]{tmp - 1, tmp + 1, tmp * 2}) {
                if(move < 0 || move > 100000 || time[move] > 0 ||move == N) continue;

                queue.offer(move);
                time[move] = time[tmp] + 1;
                prev[move] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        HideAndSeek4 main = new HideAndSeek4();
        main.execute(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}