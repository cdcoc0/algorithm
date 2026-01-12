package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 보석 도둑_1202
 */
public class JewelryThief_1202 {
    private long getValue(PriorityQueue<int[]> jewelry, TreeMap<Integer,Integer> bag) {
        // 가장 값비싼 보석, 가장 용량이 작은 가방부터 비교
        long sum = 0;
        while(!jewelry.isEmpty() && !bag.isEmpty()) {
            int[] tmp = jewelry.poll();
            int m = tmp[0];

            Integer key = bag.ceilingKey(m);
            if(key == null) continue;

            sum += tmp[1];

            bag.put(key, bag.get(key)-1);
            if(bag.get(key) <= 0) {
                bag.remove(key);
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        JewelryThief_1202 main = new JewelryThief_1202();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        PriorityQueue<int[]> jewelry = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);    // price descending order
        for(int i = 0; i < N; i++) {
            String[] MV =  br.readLine().split(" ");
            jewelry.offer(new int[]{Integer.parseInt(MV[0]), Integer.parseInt(MV[1])});
        }

        // capacity ascending order
        TreeMap<Integer, Integer> bag = new TreeMap<>();
        for(int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            bag.put(tmp, bag.getOrDefault(tmp, 0) + 1);
        }

        System.out.println(main.getValue(jewelry, bag));
    }
}

