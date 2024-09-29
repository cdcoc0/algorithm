package basic.search.graph;

import java.util.LinkedList;

/* DFS 재귀함수 */
public class DepthFirstSearch1 {

    boolean[] visited = new boolean[7];

    LinkedList<Integer>[] nodes = new LinkedList[7];

    private DepthFirstSearch1() {
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

    private void Dfs(int currentNode) {
        if(!visited[currentNode]) {
            visited[currentNode] = true;
            System.out.println(currentNode + " ->");
        }

        for(int i = 0; i < nodes[currentNode].size(); i++) {
            int nextNode = nodes[currentNode].get(i);
            if(!visited[nextNode]) {
                Dfs(nextNode);
            }
        }
    }
    public static void main(String[] args) {
        DepthFirstSearch1 dfs1 = new DepthFirstSearch1();
        dfs1.Dfs(1);
    }
}
