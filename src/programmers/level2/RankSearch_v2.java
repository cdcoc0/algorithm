package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 순위 검색 (2021 KAKAO BLIND RECRUITMENT)
 * comment : 완전탐색, 효율성 실패
 */
public class RankSearch_v2 {
    private int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] conditions = {{"cpp", "java", "python"}, {"backend", "frontend"}, {"junior", "senior"}, {"chicken", "pizza"}};
        Stack<String[]> stack = new Stack<>();

        TreeMap<Integer, HashMap<String, Integer>> scores = new TreeMap<>();

        // score순으로 정렬
        for(String i : info) {
            int idx = i.lastIndexOf(" ");
            int score = Integer.parseInt(i.substring(idx+1));
            i = i.substring(0, idx);
            HashMap<String, Integer> tmp = scores.getOrDefault(score, new HashMap<>());
            tmp.put(i, tmp.getOrDefault(i, 0)+1);

            scores.put(score, tmp);
        }

        for(int i = 0; i < query.length; i++) {
            String q = query[i];
            q = q.replaceAll(" and ", " ");
            String[] qs = q.split(" ");

            int score = Integer.parseInt(qs[qs.length-1]);
            int count = 0;

            Map<Integer, HashMap<String, Integer>> compare = scores.tailMap(score, true);

            if("-".equals(qs[0])) {
                for(String s : conditions[0]) {
                    stack.push(new String[]{s, "1"});
                }
            } else {
                stack.push(new String[]{qs[0], "1"});
            }

            while(!stack.isEmpty()) {
                String[] cur = stack.pop();
                int idx = Integer.parseInt(cur[1]);

                if(idx == 4) {
                    for(Integer key : compare.keySet()) {
                        count += compare.get(key).getOrDefault(cur[0], 0);
                    }

                    continue;
                }

                if("-".equals(qs[idx])) {
                    for(String s : conditions[idx]) {
                        stack.push(new String[]{cur[0] + " " + s, String.valueOf(idx+1)});
                    }
                } else {
                    stack.push(new String[]{cur[0] + " " + qs[idx], String.valueOf(idx+1)});
                }
            }

            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        RankSearch_v2 main = new RankSearch_v2();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        main.solution(info, query);
    }
}
