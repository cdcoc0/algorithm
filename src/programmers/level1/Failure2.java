package programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 실패율 */
public class Failure2 {
    private static int[] solution(int N, int[] stages) {
        double[] enter = new double[N + 2];
        int idx = stages.length;

        for (int stage : stages) {
            enter[stage]++;
        }

        Map<Integer, Double> failure = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            double tmp = enter[i];
            failure.put(i, tmp == 0 ? tmp : tmp / idx);
            idx -= tmp;
        }

        Map<Integer, Double> rank = new TreeMap<>((o1, o2) -> {
            int lengthDifference = failure.get(o2).compareTo(failure.get(o1));
            if (lengthDifference != 0) return lengthDifference;
            return o1.compareTo(o2);
        });

        rank.putAll(failure);

        int[] answer = new int[N];
        int ptr = 0;
        for(int key: rank.keySet()) {
            answer[ptr++] = key;
        }

        return answer;
        //return rank.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        solution(N, stages);
    }
}
