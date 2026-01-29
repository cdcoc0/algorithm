package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 튜플 (2019 카카오 개발자 겨울 인턴십)
 * comment : set으로 중복값 체크 (sum값에서 차감하는 방법도 유용해보임)
 */
public class Tuple {
    private int[] solution(String s) {
        String[] split = s.substring(2, s.length()-2).split("},\\{");
        Arrays.sort(split, Comparator.comparingInt(String::length));

        int[] answer = new int[split.length];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            String[] tmp = split[i].split(",");
            for(String t : tmp) {
                if(set.add(t))  {
                    answer[i] = Integer.parseInt(t);
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Tuple main = new Tuple();

        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        main.solution(s);
    }
}
