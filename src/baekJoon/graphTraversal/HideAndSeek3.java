package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/* 숨바꼭질3 */
public class HideAndSeek3 {
    private void execute(int N, int K) {
        boolean[] area = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int location = tmp[0];
            int time = tmp[1];

            if(location == K) {
                System.out.println(time);
                return;
            }

            for(int move : new int[]{location * 2, location - 1, location + 1}) {
                if(move < 0 || move > 100000 || area[move]) continue;

                area[move] = true;
                queue.offer(new int[]{move, move == location * 2 ? time : time + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        HideAndSeek3 main = new HideAndSeek3();
        main.execute(N, K);
    }
}
