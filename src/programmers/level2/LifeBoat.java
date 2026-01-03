package programmers.level2;

import java.util.Arrays;

/**
 * 구명보트 (탐욕법, Greedy)
 */
public class LifeBoat {
    private int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int end = 0;
        for(int i = people.length-1; end <= i; i--){
            if(people[i] + people[end] <= limit) {
                end++;
            }

            answer++;
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        LifeBoat main = new LifeBoat();

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        main.solution(people, limit);
    }
}
