package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 기능개발 */
public class FeatureDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++) {
            int remains = 100 - progresses[i];
            int day = remains / speeds[i] + Math.min(1, remains % speeds[i]);

            if(!days.isEmpty() && days.peek() < day) {
                list.add(days.size());
                days.clear();
            }

            days.offer(day);
        }

        list.add(days.size());

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        FeatureDevelopment main = new FeatureDevelopment();
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        main.solution(progresses, speeds);
    }
}
