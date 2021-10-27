package programmers.level1;

import java.util.Iterator;
import java.util.TreeSet;

public class PickTwoAndSum2 {
    static int[] solution(int[] numbers) {
        TreeSet<Integer> ts = new TreeSet();

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                ts.add(numbers[i] + numbers[j]);
            }
        }

        ts.toArray();
        Iterator it = ts.iterator();
        int[] result = new int[ts.size()];
        int ptr = 0;
        for(int num : ts) {
            result[ptr++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {2, 1, 3, 4, 1};
        System.out.println(solution(num));
    }
}
