package programmers.level1;

import java.util.Arrays;

/* 예산 */
public class Budget2 {
    private static int solution(int[] d, int budget) {
        int excluded = 0;
        int tot = Arrays.stream(d).sum();    /* 불필요한 리소스..! budget 그대로 활용하면 성능 개선됨 */

        Arrays.sort(d);

        for(int i = d.length - 1; i >= 0; i--) {
            if(budget >= tot) {
                break;
            }

            tot -= d[i];
            excluded++;
        }

        return d.length - excluded;

//        int answer = 0;
//
//        Arrays.sort(d);
//
//        for(int i = 0; i < d.length; i++) {
//            budget -= d[i];
//
//            if(budget < 0) {
//                break;
//            }
//
//            answer++;
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(solution(d, budget));
    }
}
