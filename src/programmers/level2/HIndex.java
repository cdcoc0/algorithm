package programmers.level2;

import java.util.Arrays;

/* H-Index */
public class HIndex {
    private int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;

        Arrays.sort(citations);

        for(int i = len-1; i >= 0; i--) {
            if(citations[i] >= len-i) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        HIndex main = new HIndex();

        int[] citations = {5, 6, 8, 8, 9, 10, 11, 12, 13};
        main.solution(citations);
    }
}
