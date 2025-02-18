package basic.search.graph;

import java.util.Stack;

/* DFS (stack) */
public class DepthFirstSearchStack extends SampleNodeUtils {
    private void executeDfs(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node n = stack.pop();
            if(n.getIsVisited()) continue;  /* 방문한 노드 제외 */

            n.setIsVisited(true);
            System.out.println("[node] : " + n.getData());

            for(int i = n.getNeighbors().size() - 1; i >= 0; i--) {
                Node neighbor = n.getNeighbors().get(i);
                if(!neighbor.getIsVisited()) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchStack dfs = new DepthFirstSearchStack();
        Node[] nodeList = dfs.getSampleNodeList();

        dfs.executeDfs(nodeList[1]);
    }
}
