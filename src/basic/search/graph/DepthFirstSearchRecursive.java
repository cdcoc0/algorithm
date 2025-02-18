package basic.search.graph;

/* DFS (recursive) */
public class DepthFirstSearchRecursive extends SampleNodeUtils {
    private void executeDfs(Node node) {
        System.out.println("node : " + node.getData());
        node.setIsVisited(true);

        for(Node n : node.getNeighbors()) {
            if(!n.getIsVisited()) {
                executeDfs(n);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearchRecursive dfs = new DepthFirstSearchRecursive();
        Node[] nodeList = dfs.getSampleNodeList();

        System.out.println("DFS START");
        dfs.executeDfs(nodeList[1]);
    }
}
