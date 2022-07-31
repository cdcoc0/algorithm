package programmers.level1;

public class lottery {
    static int[] solution(int[] lottos, int[] win_nums) {
        int erased = 0;
        int win = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                erased++;
                continue;
            }

            for(int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    win++;
                    break;
                }
            }
        }

        int[] answer = {win + erased == 0 ? 6 : 7 - (win + erased), win == 0 ? 6 : 7 - win};

        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        solution(lottos, win_nums);
    }
}
