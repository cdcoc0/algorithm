package programmers.level1;

public class harshadNumber {
    static boolean harshad(int x) {
        int copyX = x;
        int sum = 0;
        boolean answer = false;

        while(copyX > 0) {
            sum += copyX % 10;
            copyX /= 10;
        }

        if(x % sum == 0) {
            answer = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(harshad(12));
    }
}
