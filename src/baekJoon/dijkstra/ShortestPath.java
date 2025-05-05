package baekJoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 최단 경로 */
public class ShortestPath {
    static class Node {
        int index;
        int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    static void execute(int V, int start, List<List<Node>> routes) {
        int[] dist = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;

        for(int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        queue.offer(new Node(start, 0));

        // just counts (v-1 times)
//        for(int i = 1; i < V; i++) {
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int minIdx = cur.index;

            // update visited status
            visited[minIdx] = true;

            // update neighboring nodes
            for(Node r : routes.get(minIdx)) {
                if(!visited[r.index] && dist[r.index] > r.distance + dist[minIdx]) {
                    dist[r.index] = r.distance + dist[minIdx];
                    queue.offer(new Node(r.index, dist[r.index]));
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int V = Integer.parseInt(first[0]);
        int E = Integer.parseInt(first[1]);

        List<List<Node>> routes = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            routes.add(new ArrayList<Node>());
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int len = Integer.parseInt(line[2]);

            routes.get(a).add(new Node(b, len));
        }

        execute(V, start, routes);
    }
}
