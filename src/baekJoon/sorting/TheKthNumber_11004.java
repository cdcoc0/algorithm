package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * K번째 수_11004
 */
public class TheKthNumber_11004 {
    private void swap(Integer[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private int getK(Integer[] numbers, int K) {
        int left = 0;
        int right = numbers.length-1;

        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();

        lStack.push(left);
        rStack.push(right);

        while(!lStack.isEmpty()) {
            int pl = left = lStack.pop();
            int pr = right = rStack.pop();
            int x = numbers[(left + right) / 2]; // pivot

            while(pl <= pr) {
                while(numbers[pl] < x) pl++;
                while(numbers[pr] > x) pr--;
                if(pl <= pr) {
                    swap(numbers, pl++, pr--);
                }
            }

            if(pl < right && pl <= K) {
                lStack.push(pl);
                rStack.push(right);
            }

            if (left < pr && K <= pr) {
                lStack.push(left);
                rStack.push(pr);
            }
        }

        return numbers[K];
    }

    public static void main(String[] args) throws IOException {
        TheKthNumber_11004 main = new  TheKthNumber_11004();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int K = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        Integer[] numbers = new Integer[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(secondLine[i]);
        }

        System.out.println(main.getK(numbers, K-1));
    }
}
