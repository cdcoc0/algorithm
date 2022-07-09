package programmers.level1;

public class SumNums {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }

        return answer;
    }

    public static void main(String[] args) {
        SumNums sn = new SumNums();

        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(sn.solution(absolutes, signs));
    }
}
