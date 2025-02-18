package basic.search.graph;

import java.util.LinkedList;
import java.util.Queue;

/* BFS (queue) */
public class BreadthFirstSearch extends SampleNodeUtils{
    private void executeBfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.getIsVisited()) continue;  /* 방문한 노드 제외 */

            System.out.println("node : " + n.getData());
            n.setIsVisited(true);

            for(Node neighbor : n.getNeighbors()) {
                if(!neighbor.getIsVisited()) {
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Node[] nodeList = bfs.getSampleNodeList();

        bfs.executeBfs(nodeList[1]);
    }
}
