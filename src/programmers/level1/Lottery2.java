package programmers.level1;

/* 로또 최고 순위와 최저 순위 */
public class Lottery2 {
    private static int[] solution(int[] lottos, int[] win_nums) {
        int win = 0;
        int blur = 0;

        for(int l : lottos) {
            if(l == 0) {
                blur++;
                continue;
            }

            for(int w : win_nums) {
                if(l == w) {
                    win++;
                    break;
                }
            }
        }

        int min = win == 0 ? 6 : 6-(win-1);
        int max = blur == 6 ? 1 : min - blur;
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        solution(lottos, win_nums);
    }
}
