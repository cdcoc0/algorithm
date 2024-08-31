package programmers.level1;

/* 덧칠하기 */
public class PaintOver {
    private static int solution(int n, int m, int[] section) {
        int answer = 0;
        int rest = m;

        for(int i = 1; i < section.length; i++) {
            int tmp = section[i] - section[i - 1];
            if(tmp < rest) {
                rest -= tmp;
            } else {
                rest = m;
                answer++;
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};
        System.out.println(solution(n, m, section));
    }
}
