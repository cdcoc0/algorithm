package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 우체국_2141
 */
public class PostOffice_2141 {
    private long getLocation(PriorityQueue<long[]> queue, long sum){
        long accumulated = queue.peek()[1];

        while(!queue.isEmpty() && accumulated < (sum+1)/2){
            queue.poll();
            accumulated += queue.peek()[1];
        }

        return queue.poll()[0];
    }

    public static void main(String[] args) throws IOException {
        PostOffice_2141 main = new PostOffice_2141();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<long[]> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long sum = 0;
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            sum += Long.parseLong(split[1]);
            queue.add(new long[]{Long.parseLong(split[0]), Long.parseLong(split[1])});
        }

        System.out.println(main.getLocation(queue, sum));
    }
}
