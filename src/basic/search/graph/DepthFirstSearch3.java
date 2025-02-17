package basic.search.graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch3 {
    public class Node {
        int data;
        List<Node> neighbors;
        boolean isVisited;

        public Node(int data) {
            this.data = data;
            neighbors = new ArrayList<>();
            isVisited = false;
        }
    }

    private void executeDfs(Node node) {
        System.out.println("node : " + node.data);
        node.isVisited = true;

        for(Node n : node.neighbors) {
            if(!n.isVisited) {
                executeDfs(n);
            }
        }
    }

    private void setNodes() {
        Node[] nodeList = new Node[9];
        for(int i = 1; i < nodeList.length; i++) {
            nodeList[i] = new Node(i);
        }

        nodeList[1].neighbors.add(nodeList[2]);
        nodeList[1].neighbors.add(nodeList[3]);
        nodeList[1].neighbors.add(nodeList[8]);
        nodeList[2].neighbors.add(nodeList[1]);
        nodeList[2].neighbors.add(nodeList[6]);
        nodeList[2].neighbors.add(nodeList[8]);
        nodeList[3].neighbors.add(nodeList[1]);
        nodeList[3].neighbors.add(nodeList[5]);
        nodeList[4].neighbors.add(nodeList[5]);
        nodeList[4].neighbors.add(nodeList[7]);
        nodeList[5].neighbors.add(nodeList[3]);
        nodeList[5].neighbors.add(nodeList[4]);
        nodeList[5].neighbors.add(nodeList[7]);
        nodeList[6].neighbors.add(nodeList[2]);
        nodeList[7].neighbors.add(nodeList[4]);
        nodeList[7].neighbors.add(nodeList[5]);
        nodeList[8].neighbors.add(nodeList[1]);
        nodeList[8].neighbors.add(nodeList[2]);

        System.out.println("DFS START");
        executeDfs(nodeList[1]);
    }

    public static void main(String[] args) {
        DepthFirstSearch3 dfs = new DepthFirstSearch3();
        dfs.setNodes();
    }
}
