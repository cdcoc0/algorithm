package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/* 숨바꼭질2 */
public class HideAndSeek2 {
    private void execute(int N, int K) {
        int minTime = 1000000;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[100001];

        Consumer<int[]> addQueue = t -> {
            int next = t[0];
            int time = t[1];

            if(visited[next] > 0 && visited[next] < time) return;

            if(visited[next] == 0) {
                visited[next] = time;
            }

            queue.offer(t);
        };

        queue.offer(new int[]{N, 0});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int location = tmp[0];
            int time = tmp[1];

            if(location == K && time <= minTime) {
                minTime = count == 0 ? time : minTime;
                count++;
            }

            int forword = location + 1;
            int back = location -1;
            int dbForward = location * 2;
            time++;

            if(back >= 0) {
                addQueue.accept(new int[]{back, time});
            }

            if(forword <= 100000) {
                addQueue.accept(new int[]{forword, time});
            }

            if(dbForward <= 100000 && location > 0) {
                addQueue.accept(new int[]{dbForward, time});
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        HideAndSeek2 main = new HideAndSeek2();
        main.execute(N, K);
    }
}
