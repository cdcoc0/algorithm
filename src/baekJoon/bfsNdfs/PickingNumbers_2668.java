package baekJoon.bfsNdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 숫자고르기_2668
 */
public class PickingNumbers_2668 {
    private void getResult(int N, int[] arr) {
        HashSet<Integer> list = new HashSet<>();
        PriorityQueue<Integer> result = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) {
            if(i > arr[i]) continue;    // 어차피 순환하기 때문에 이미 지나친 숫자는 다시 확인할 필요 없음 (kinda memoization,,)

            int idx = i;
            while(!list.contains(idx)) {
                list.add(idx);
                idx = arr[idx];
            }

            if(idx == i) {
                if(!result.contains(i)) result.addAll(list);
                if(result.contains(i) && list.size() > result.size()) {
                    result.clear();
                    result.addAll(list);
                }
            }

            list.clear();
        }

        System.out.println(result.size());
        while(!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        PickingNumbers_2668 main = new PickingNumbers_2668();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        main.getResult(N, arr);
    }
}

