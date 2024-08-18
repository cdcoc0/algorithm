package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 카드 뭉치 */
public class AStackOfCards {
    private static String solution(String[] cards1, String[] cards2, String[] goal) {
        int ptr1 = 0;
        int ptr2 = 0;

        for (String s : goal) {
            String c1 = cards1[ptr1];
            String c2 = cards2[ptr2];

            if (c1.equals(s)) {
                ptr1++;
                ptr1 = Math.min(ptr1, cards1.length - 1);
            } else if (c2.equals(s)) {
                ptr2++;
                ptr2 = Math.min(ptr2, cards2.length - 1);
            } else {
                return "No";
            }
        }

        return "Yes";
    }
    public static void main(String[] args) {
        String[] cards1 = {"a", "b", "c"};
        String[] cards2 = {"d", "e", "f"};
        String[] goal = {"a", "d", "f"};

        System.out.println(solution(cards1, cards2, goal));
    }
}
