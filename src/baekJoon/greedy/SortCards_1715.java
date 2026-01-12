package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기_1715
 */
public class SortCards_1715 {
    private int getCount(PriorityQueue<Integer> queue){
        int count = 0;
        while(queue.size() > 1) {
            int tmp = queue.poll()+queue.poll();
            count += tmp;
            queue.add(tmp);
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        SortCards_1715 main = new SortCards_1715();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        System.out.println(main.getCount(queue));
    }
}
