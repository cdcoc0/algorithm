package programmers.level1;

import java.util.Arrays;

/* K번째 수 */
public class KNum {
    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int[] split = new int[end - start];
            for(int j = 0; j < end - start; j++) {
                split[j] = array[j+start];
            }    /* Arrays.copyOfRange <--- 대체 가능! */

            Arrays.sort(split);
            answer[i] = split[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution(array, commands);
    }
}
