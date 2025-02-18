package basic.search.graph;

public class SampleNodeUtils {
    Node[] sampleNodeList;

    private void setSampleNodeList() {
        sampleNodeList = new Node[9];
        for(int i = 1; i < sampleNodeList.length; i++) {
            sampleNodeList[i] = new Node(i);
        }

        sampleNodeList[1].addNeighbor(sampleNodeList[2]);
        sampleNodeList[1].addNeighbor(sampleNodeList[3]);
        sampleNodeList[1].addNeighbor(sampleNodeList[8]);
        sampleNodeList[2].addNeighbor(sampleNodeList[1]);
        sampleNodeList[2].addNeighbor(sampleNodeList[6]);
        sampleNodeList[2].addNeighbor(sampleNodeList[8]);
        sampleNodeList[3].addNeighbor(sampleNodeList[1]);
        sampleNodeList[3].addNeighbor(sampleNodeList[5]);
        sampleNodeList[4].addNeighbor(sampleNodeList[5]);
        sampleNodeList[4].addNeighbor(sampleNodeList[7]);
        sampleNodeList[5].addNeighbor(sampleNodeList[3]);
        sampleNodeList[5].addNeighbor(sampleNodeList[4]);
        sampleNodeList[5].addNeighbor(sampleNodeList[7]);
        sampleNodeList[6].addNeighbor(sampleNodeList[2]);
        sampleNodeList[7].addNeighbor(sampleNodeList[4]);
        sampleNodeList[7].addNeighbor(sampleNodeList[5]);
        sampleNodeList[8].addNeighbor(sampleNodeList[1]);
        sampleNodeList[8].addNeighbor(sampleNodeList[2]);
    }

    Node[] getSampleNodeList() {
        this.setSampleNodeList();
        return this.sampleNodeList;
    }
}
