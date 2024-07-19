package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/* 모의고사 */
public class MockTest {
    private static int[] solution(int[] answers) {
        int[] n1 = {1,2,3,4,5};
        int[] n2 = {2,1,2,3,2,4,2,5};
        int[] n3 = {3,3,1,1,2,2,4,4,5,5};

        int[] chk = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == n1[i % n1.length]) { chk[0]++; }
            if(answers[i] == n2[i % n2.length]) { chk[1]++; }
            if(answers[i] == n3[i % n3.length]) { chk[2]++; }
        }

        int max = Math.max(chk[0], Math.max(chk[1], chk[2]));
        List<Integer> listMax = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(chk[i] == max) {
                listMax.add(i + 1);
            }
        }

        //return listMax.stream().mapToInt(Integer::intValue).toArray();    ---> stream이 무지 느림..!

        int[] result = new int[listMax.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = listMax.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        solution(answers);
    }
}
