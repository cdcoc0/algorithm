package programmers.level1;

public class NumberOfDivisor {
    static int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            if(Math.sqrt(i) == Math.floor(Math.sqrt(i)))
                answer -= i;
            else
                answer += i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }
}
