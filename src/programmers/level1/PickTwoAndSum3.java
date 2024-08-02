package programmers.level1;

import java.util.*;

/* 두 개 뽑아서 더하기 */
public class PickTwoAndSum3 {
    private static int[] solution(int[] numbers) {
        Set<Integer> sum = new TreeSet<>();
        int len = numbers.length;

        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[sum.size()];
        int ptr = 0;
        for(int s : sum) {
            answer[ptr++] = s;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        solution(numbers);
    }
}
