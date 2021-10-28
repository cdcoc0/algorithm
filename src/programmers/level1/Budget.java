package programmers.level1;

import java.util.Arrays;

public class Budget {
    static int solution(int[] d, int budget) {
        int sum = 0;
        int max = d.length - 1;

        Arrays.sort(d);

        for(int p : d) {
            sum += p;
        }

        while(sum > budget) {
            sum -= d[max--];
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[] d = {2, 2, 3, 3};
        System.out.println(solution(d, 10));
    }
}
