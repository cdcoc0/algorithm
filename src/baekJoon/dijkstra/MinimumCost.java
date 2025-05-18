package baekJoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* 1916. 최소비용 구하기 */
public class MinimumCost {
    void execute(int N, int[][] info, int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, 1000000000);

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o1 -> o1[1]));
        queue.offer(new int[]{end, 0});
        visited[end] = true;
        dist[end] = 0;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int index = cur[0];
            int distance = cur[1];

            visited[index] = true;

            for(int i = 1; i <= N; i++) {
                if(!visited[i] && info[i][index] > -1
                        && dist[i] > distance + info[i][index]) {
                    dist[i] = distance + info[i][index];
                    queue.offer(new int[]{i, dist[i]});
                }
            }
        }

        System.out.println(dist[start] == 1000000000 ? 0 : dist[start]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // the number of cities
        int M = Integer.parseInt(br.readLine());    // the number of buses
        int[][] info = new int[N+1][N+1];

        for(int[] i : info) {
            Arrays.fill(i, -1);
        }

        for(int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int value = Integer.parseInt(split[2]);

            info[a][b] = info[a][b] == -1 ? value : Math.min(info[a][b], value);
        }

        String[] arr = br.readLine().split(" ");
        int start = Integer.parseInt(arr[0]);
        int end = Integer.parseInt(arr[1]);

        MinimumCost main = new MinimumCost();
        main.execute(N, info, start, end);
    }
}
