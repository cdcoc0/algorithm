package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* A -> B */
public class AToB {
    private void execute(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1});

        while(!queue.isEmpty()) {
            long[] tmp = queue.poll();
            long b = tmp[0];
            long cnt = tmp[1];

            if(b > B) continue;

            if(b == B) {
                System.out.println(tmp[1]);
                return;
            }

            queue.offer(new long[]{b * 2, cnt + 1});
            queue.offer(new long[]{b * 10 + 1, cnt + 1});
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long A = Integer.parseInt(split[0]);
        long B = Integer.parseInt(split[1]);

        AToB main = new AToB();
        main.execute(A, B);
    }
}
