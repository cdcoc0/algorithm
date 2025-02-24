package baekJoon.graphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 바이러스 */
public class Virus {
    private void execute(int n, int k, List<List<Integer>> neighbors) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        int count = 0;
        visited[0] = true;

        while(!queue.isEmpty()) {
            int data = queue.poll();
            for(Integer neighbor : neighbors.get(data)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    count++;
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<List<Integer>> neighbors = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }

        for(int i = 0; i < k; i++) {
            String[] connection = br.readLine().split(" ");
            int num1 = Integer.parseInt(connection[0]);
            int num2 = Integer.parseInt(connection[1]);

            neighbors.get(num1 - 1).add(num2 - 1);
            neighbors.get(num2 - 1).add(num1 - 1);
        }

        Virus main = new Virus();
        main.execute(n, k, neighbors);
    }
}
