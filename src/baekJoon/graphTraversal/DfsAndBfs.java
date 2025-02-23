package baekJoon.graphTraversal;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Dfs와 Bfs */
public class DfsAndBfs {
    StringJoiner join1;
    StringJoiner join2;

    class Node {
        int data;
        List<Node> neighbors;
        boolean isDfsVisited;
        boolean isBfsVisited;

        public Node(int data) {
            this.data = data;
            neighbors = new ArrayList<>();
            isDfsVisited = false;
            isBfsVisited = false;
        }
    }

    private void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            if(tmp.isBfsVisited) continue;

            tmp.isBfsVisited = true;
            join2.add(tmp.data + "");

            for(Node neighbor : tmp.neighbors) {
                if(!neighbor.isBfsVisited) {
                    queue.offer(neighbor);
                }
            }
        }
    }

    private void dfs(Node node) {
        node.isDfsVisited = true;
        join1.add(node.data + "");

        for(Node neighbor : node.neighbors) {
            if(!neighbor.isDfsVisited) {
                dfs(neighbor);
            }
        }
    }

    private void execute() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        int cntNode = Integer.parseInt(split[0]);
        int cntLine = Integer.parseInt(split[1]);
        int start = Integer.parseInt(split[2]);

        Map<Integer, Node> nodes = new HashMap<>();

        for(int i = 0; i < cntLine; i++) {
            String connection = br.readLine();
            String[] splitConn = connection.split(" ");
            int conn1 = Integer.parseInt(splitConn[0]);
            int conn2 = Integer.parseInt(splitConn[1]);

            Node tmp1 = nodes.getOrDefault(conn1, new Node(conn1));
            Node tmp2 = nodes.getOrDefault(conn2, new Node(conn2));
            tmp1.neighbors.add(tmp2);
            tmp2.neighbors.add(tmp1);

            nodes.put(conn1, tmp1);
            nodes.put(conn2, tmp2);
        }

        if(nodes.containsKey(start)) {
            for(Node n : nodes.values()) {
                n.neighbors.sort(Comparator.comparingInt(o -> o.data));
            }
            dfs(nodes.get(start));
            bfs(nodes.get(start));
        } else {
            join1.add(start + "");
            join2.add(start + "");
        }

        System.out.println(join1.toString());
        System.out.println(join2.toString());
    }

    public static void main(String[] args) throws IOException {
        DfsAndBfs dfsAndBfs = new DfsAndBfs();
        dfsAndBfs.join1 = new StringJoiner(" ");
        dfsAndBfs.join2 = new StringJoiner(" ");

        dfsAndBfs.execute();
    }
}
