package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 잃어버린 괄호_1541
 */
public class LostBrackets_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Solution.solution(exp);
    }

    static class Solution {
        static void solution(String exp) {
            //-뒤의 값을 최대로 만들어야 함
            String[] minus = exp.split("-");
            int sum = 0;

            for(int i = 0; i < minus.length; i++) {
                String[] plus = minus[i].split("\\+");
                int sumPlus = 0;
                for(String s : plus) {
                    sumPlus += Integer.parseInt(s);
                }

                if(i > 0) sumPlus *= -1;
                sum += sumPlus;
            }

            System.out.println(sum);
        }
    }
}
