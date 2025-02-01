package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/* 줄 서는 방법 */
public class WaysOfQueuing {
    static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>(n);

        long factor = 1;
        for(int i = 1; i <= n; i++) {
            factor *= i;
            nums.add(i);
        }

        for(int i = n; i >= 1; i--) {
            factor /= i;
            int quotient = (int)(k / factor);
            long remainder = k % factor;

            if(remainder == 0) {
                quotient -= 1;
                remainder = factor;
            }

            answer[n - i] = nums.get(quotient);
            nums.remove(quotient);
            k = remainder;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        long k = 5;

        solution(n, k);
    }
}
