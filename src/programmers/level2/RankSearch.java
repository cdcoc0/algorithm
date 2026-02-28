package programmers.level2;

import java.util.*;

/**
 * 순위 검색 (2021 KAKAO BLIND RECRUITMENT)
 * comment : String -> StringBuilder 사용해 성능 개선 가능
 */
public class RankSearch {
    private void dfs(String[] info, Map<String, List<Integer>> map, String key, int lvl) {
        if(lvl == 4) {
            List<Integer> tmp = map.getOrDefault(key, new ArrayList<>());
            tmp.add(Integer.parseInt(info[lvl]));
            map.put(key, tmp);
        } else {
            dfs(info, map, key + info[lvl], lvl+1);
            dfs(info, map, key + "-", lvl+1);
        }
    }

    private int binarySearch(List<Integer> list, int target) {
        if(list.isEmpty() || list.get(list.size()-1) < target) {return list.size();}

        int left = 0;
        int right = list.size()-1;

        while(left < right) {
            int mid = (right + left) / 2;

            if(list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    private int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> map = new HashMap<>();

        for(String i : info) {
            String[] split = i.split(" ");

            // 가능한 모든 조합에 점수 입력
            dfs(split, map, "", 0);
        }

        // 정렬
        for(List<Integer> list : map.values()) {
            list.sort(Comparator.naturalOrder());
        }

        for(int i = 0; i < answer.length; i++) {
            String[] q = query[i].replaceAll(" and ", " ").split(" ");
            String key = q[0] + q[1] + q[2] + q[3];

            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            answer[i] = list.size()-binarySearch(list, Integer.parseInt(q[4]));
        }

        return answer;
    }

    public static void main(String[] args) {
        RankSearch main = new RankSearch();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        main.solution(info, query);
    }
}
