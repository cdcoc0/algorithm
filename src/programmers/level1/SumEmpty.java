package programmers.level1;

import java.util.*;

public class SumEmpty {
    public int solution(int[] numbers) {
        int answer = 0;

        HashMap<Integer, Integer> numList = new HashMap<>();

        for(int n : numbers) {
            numList.put(n, 0);
        }

        for(int i = 0; i <= 9; i++) {
            answer += numList.getOrDefault(i, i);
        }

        return answer;

        //45에서 빼는 방법이 가장 간단함
    }

    public static void main(String[] args) {
        SumEmpty se = new SumEmpty();

        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(se.solution(numbers));
    }
}
