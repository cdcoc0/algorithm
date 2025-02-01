package programmers.level2;

import java.util.Arrays;

/* 최대값과 최소값 */
public class MaxValueAndMinValue {
    private static String solution(String s) {
//        Stream, sort
//        int[] split = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
//        return split[0]+ " " + split[split.length-1];

        String[] split = s.split(" ");

        int min, max;
        min = max = Integer.parseInt(split[0]);
        for(int i = 1; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);

            if(tmp > max) {
                max = tmp;
            }

            if(tmp < min) {
                min = tmp;
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        System.out.println(solution(s));
    }
}
