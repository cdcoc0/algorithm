package programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 햄버거 만들기 */
public class MakingHamburgers {
    private static int solution(int[] ingredient) {
        /* STACK으로 구현해보기!!! */

        int answer = 0;
        List<Integer> things = Arrays.stream(ingredient).boxed().collect(Collectors.toList());

        for(int i = 0; i < things.size() - 3; i++) {
            if(things.get(i) == 1) {
                int vege = things.get(i + 1);
                int meat = things.get(i + 2);
                int bread = things.get(i + 3);

                if(vege == 2 && meat == 3 && bread == 1) {
                    things.remove(i+3);
                    things.remove(i+2);
                    things.remove(i+1);
                    things.remove(i);

                    answer++;
                    i = i < 3 ? -1 : i - 4;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution(ingredient));
    }
}
