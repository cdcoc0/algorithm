package programmers.level1;

import java.util.Arrays;

public class PrimeNum2 {
    private static int prime(int n) {
        int[] iPrime = new int[n + 1];

        iPrime[0] = -1;
        iPrime[1] = -1;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(iPrime[i] == -1) {continue;}
            for(int j = i+i; j <= n; j += i) {
                iPrime[j] = -1;
            }
        }

        //return Math.toIntExact(Arrays.stream(iPrime).filter(pNum -> pNum == 0).count());

//        int answer = 0;
//
//        for(int i : iPrime) {
//            if(i == 0) {
//                answer++;
//            }
//        }

//        return answer;

        return Arrays.stream(iPrime).filter(pNum -> pNum == 0).toArray().length;
    }

    private static int solution(int n) {
        return prime(n);
    }

    public static void main(String[] args) {
        System.out.println(solution(1000000));
    }
}
