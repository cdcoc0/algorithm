package programmers.level1;

public class collatzConjecture {
    static int collatz(int num) {
        int answer = 0;
        long copyNum = (long)num;
        while(copyNum != 1) {
            if(copyNum % 2 == 0)
                copyNum /= 2;
            else
                copyNum = copyNum * 3 + 1;

            answer++;

            if(answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(collatz(626331));
    }
}
