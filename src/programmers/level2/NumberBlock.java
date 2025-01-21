package programmers.level2;

import java.util.Arrays;

/* 숫자 블록 */
public class NumberBlock {
    static int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];

        for(long i = begin; i <= end; i++) {
            int idx = (int)(i - begin);
            answer[idx] = 1;

            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    if(i / j <= 10000000) {
                        answer[idx] = (int)i / j;
                        break;
                    } else {
                        answer[idx] = j;
                    }
                }
            }
        }

        if(begin == 1) { answer[0] = 0; }

        return answer;
    }

    public static void main(String[] args) {
//        long begin = 477559014;
//        long end = 477559014;

        long begin = 1000000000;
        long end = 1000000000;

        solution(begin, end);
    }
}
