package programmers.level2;

/* 예상 대진표 */
public class ExpectedMatchSchedule {
    int solution(int n, int a, int b)
    {
        int answer = 0;
        a -= 1;
        b -= 1;

        while(a != b) {
            a /= 2;
            b /= 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ExpectedMatchSchedule main = new ExpectedMatchSchedule();
        int n = 8;
        int a = 4;
        int b = 7;

        main.solution(n, a, b);
    }
}
