package baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1로 만들기_1463
 * comment : bfs가 되어버림
 */
public class MakeIt1_1463 {
    private int getMinOperation(int X) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {X,0});

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int count = tmp[1];

            if(x == 1) return count;

            if(x%3 == 0) queue.offer(new int[] {x/3,count+1});
            if(x%2 == 0) queue.offer(new int[] {x/2,count+1});
            if(x > 1) queue.offer(new int[] {x-1,count+1});
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        MakeIt1_1463 main = new MakeIt1_1463();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        System.out.println(main.getMinOperation(X));
    }
}
