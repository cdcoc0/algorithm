package programmers.level1;

public class intervalNums {
    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long a = x;
        for(int i = 0; i < n; i++) {
            answer[i] = x + (x * i);
        }
        //answer[0] = x;
        //그 뒤부터 x씩 더하기

        return answer;
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(solution(x, n));
    }
}
