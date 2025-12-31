package programmers.level2;

/**
 * 카펫 (완전탐색)
 */
public class Carpet {
    private int[] solution(int brown, int yellow) {
        int[] answer = {};

        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0 && (i + yellow / i) * 2 + 4 == brown) {
                answer = new int[]{yellow / i + 2, i + 2};
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Carpet main = new Carpet();

        int brown = 10;
        int yellow = 2;
        main.solution(brown, yellow);

        // 가로 >= 세로
        // 테두리 중복 4개
        // 내부 가로 = 테두리 가로 - 2
        // 내부 세로 = 테두리 세로 - 2
    }
}
