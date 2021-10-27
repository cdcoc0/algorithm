package programmers.level1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class PickTwoAndSum {
    static int[] solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                sb.append(String.valueOf(sum) + " ");
            }
        }

        StringTokenizer st = new StringTokenizer(sb.toString());
        int[] temp = new int[st.countTokens()];
        int ptr = 0;
        boolean duplicate = false;
        for(int i = 0; i < temp.length; i++) {
            int tk = Integer.parseInt(st.nextToken());
            for(int j = 0; j < ptr; j++) {
                if(temp[j] == tk) {
                    duplicate = true;
                    break;
                }
            }
            if(duplicate == false) {
                temp[ptr++] = tk;
            }
            duplicate = false;
        }

        int[] answer = new int[ptr];
        for(int i = 0; i < ptr; i++) {
            answer[i] = temp[i];
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] num = {2, 1, 3, 4, 1};
        System.out.println(solution(num));
    }
}
