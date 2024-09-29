package basic.search.graph;

import java.util.LinkedList;
import java.util.Stack;

/* DFS 스택 */
public class DepthFirstSearch2 {
    boolean[] visited = new boolean[7];

    LinkedList<Integer>[] nodes = new LinkedList[7];

    private DepthFirstSearch2() {
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
        Stack<Integer> stack = new Stack<>();
        stack.push(currentNode);
        visited[currentNode] = true;

        while(!stack.isEmpty()) {
            int chk = stack.pop();
            System.out.println(chk + " ->");

            for(int i = nodes[chk].size() - 1; i >= 0; i--) {    // 오름차순으로 하려구
                int nextNode = nodes[chk].get(i);
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    stack.push(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch2 dfs2 = new DepthFirstSearch2();
        dfs2.Dfs(1);
    }
}
