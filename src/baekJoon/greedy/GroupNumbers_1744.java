package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 수 묶기_1744
 */
public class GroupNumbers_1744 {
    private int sumQueue(PriorityQueue<Integer> queue) {
        int result = 0;

        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            if(queue.isEmpty()) {
                result += tmp;
            } else {
                int next = queue.poll();
                result += Math.max(tmp + next, tmp * next);
            }
        }

        return result;
    }

    private int getMaxSum(PriorityQueue<Integer> pstqueue, PriorityQueue<Integer> ngtQueue) {
        int sum = 0;

        sum += this.sumQueue(pstqueue);
        sum += this.sumQueue(ngtQueue);

        return sum;
    }

    public static void main(String[] args) throws IOException {
        GroupNumbers_1744 main = new GroupNumbers_1744();
        PriorityQueue<Integer> pstqueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> ngtQueue = new PriorityQueue<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0) {
                ngtQueue.add(num);
            } else{
                pstqueue.add(num);
            }
        }

        System.out.println(main.getMaxSum(pstqueue, ngtQueue));
    }
}
