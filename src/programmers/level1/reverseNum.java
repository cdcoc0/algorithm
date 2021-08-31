package programmers.level1;

public class reverseNum {
    static int[] solution(long n) {
        String cnt = " " + n;
        int[] answer = new int[cnt.length() - 1];

        for(int i = 0; n > 0; i++) {
            answer[i] = Math.toIntExact(n % 10);
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(12345);
    }
}

//StringBuilder reverse 메서드
