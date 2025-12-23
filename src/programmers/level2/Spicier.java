package programmers.level2;

/* 더 맵게 */
public class Spicier {
    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private void heapify(int[] arr, int parent, int lastIdx) {
        // ascending order heap
        int minIdx = parent;

        while(parent * 2 + 1 <= lastIdx) {
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;

            if(leftChild <= lastIdx && arr[leftChild] < arr[minIdx]) {
                minIdx = leftChild;
            }

            if(rightChild <= lastIdx && arr[rightChild] < arr[minIdx]) {
                minIdx = rightChild;
            }

            if(parent != minIdx) {
                swap(arr, parent, minIdx);
                parent = minIdx;
            } else {
                break;
            }
        }
    }

    private int solution(int[] scoville, int K) {
        int lastIdx = scoville.length-1;
        int count = 0;

        // make scoville a heap
        for(int i = (lastIdx - 1) / 2; i >= 0; i--) {
            this.heapify(scoville, i, lastIdx);
        }

        for(int i = lastIdx; i >= 0; i--) {
            if(scoville[0] < K) {
                if(i == 0) {
                    return -1;
                }

                this.swap(scoville, 0, i);
                this.heapify(scoville, 0, i - 1);

                scoville[0] = scoville[i] + scoville[0] * 2;
                this.heapify(scoville, 0, i - 1);

                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Spicier main = new Spicier();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        main.solution(scoville, K);
    }
}
