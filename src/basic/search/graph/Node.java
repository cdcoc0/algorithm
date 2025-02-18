package basic.search.graph;

import java.util.ArrayList;
import java.util.List;

class Node {
    private final int data;
    private List<Node> neighbors;
    private boolean isVisited;

    Node(int data) {
        this.data = data;
        neighbors = new ArrayList<>();
        isVisited = false;
    }

    int getData() {
        return this.data;
    }

    List<Node> getNeighbors() {
        return this.neighbors;
    }

    boolean getIsVisited() {
        return this.isVisited;
    }

    void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    void setIsVisited(boolean visited) {
        this.isVisited = visited;
    }
}
