package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 후보키 (kakao blind recruitment)
 */
public class CandidateKey {
    private boolean isUnique(String[][] relation, int[] columns) {
        int len = relation.length;
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        for (String[] strings : relation) {
            for (int col : columns) {
                sb.append(strings[col]).append(",");
            }
            set.add(sb.toString());
            sb.setLength(0);
        }

        return set.size() == len;
    }

    private int solution(String[][] relation) {
        /**
         * 브루트 포스,,, 소스코드 가독성, 효율성 고민 필요
         */
        List<List<Integer>> unique = new ArrayList<>();
        int colLength = relation[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // set single digit elements
        for(int i = 0; i < colLength; i++) {
            int[] tmp = new int[]{i};
            if(this.isUnique(relation, tmp)) {
                unique.add(List.of(i));
            } else {
                queue.offer(tmp);
            }
        }

        // check uniqueness
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpLength = tmp.length;
            for(int i = tmp[tmpLength-1]+1; i < colLength; i++) {
                int[] arrNew = Arrays.copyOf(tmp, tmpLength+1);
                arrNew[tmpLength] = i;

                if(this.isUnique(relation, arrNew)) {
//                    unique.add(Arrays.stream(arrNew).boxed().toList());
                    unique.add(Arrays.stream(arrNew).boxed().collect(Collectors.toList()));
                } else {
                    queue.offer(arrNew);
                }
            }
        }

        // check minimality
        for(int i = 0; i < unique.size()-1; i++) {
            List<Integer> compare = unique.get(i);
            for(int j = i + 1; j < unique.size(); j++) {
                if(new HashSet<>(unique.get(j)).containsAll(compare)) {
                    unique.remove(j--);
                }
            }
        }

        return unique.size();
    }
    public static void main(String[] args) {
        CandidateKey main = new CandidateKey();

//        String[][] relation = { {"a","1","aaa","c","ng"},
//                {"a","1","bbb","e","g"},
//                {"c","1","aaa","d","ng"},
//                {"d","2","bbb","d","ng"}};  // 5
//        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};  // 2
        String[][] relation = {{"a","1","aaa","c","ng"},{"b","1","bbb","c","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};  // 3
        main.solution(relation);
        // 3, 4, 20, 22, 25, 28
    }
}