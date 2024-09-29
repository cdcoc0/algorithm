package basic.search.graph;

import java.util.LinkedList;
import java.util.Queue;

/* BFS 큐 */
public class BreadthFirstSearch1 {
    boolean[] visited = new boolean[7];

    LinkedList<Integer>[] nodes = new LinkedList[7];

    private BreadthFirstSearch1() {
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = new LinkedList<>();
        }

        this.nodes[1].add(2);
        this.nodes[1].add(3);
        this.nodes[2].add(6);
        this.nodes[3].add(4);
        this.nodes[3].add(5);
        this.nodes[4].add(3);
        this.nodes[5].add(3);
        this.nodes[6].add(2);
    }

    private void bfs(int currentNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentNode);
        visited[currentNode] = true;

        while(!queue.isEmpty()) {
            int chk = queue.poll();
            System.out.println(chk + " ->");

            for(int i = 0; i < nodes[chk].size(); i++) {
                int nextNode = nodes[chk].get(i);
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
    public static void main(String[] args) {
        BreadthFirstSearch1 bfs1 = new BreadthFirstSearch1();
        bfs1.bfs(1);
    }
}
