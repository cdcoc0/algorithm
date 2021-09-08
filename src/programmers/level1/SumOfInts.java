package programmers.level1;

public class SumOfInts {
    static long solution(int a, int b) {
        long answer = 0;
        long t = Math.abs(a - b);
        long s = a + b;

        if(a == b)
            answer = a;
        else {
            if(t % 2 == 0)
                answer = s * (t / 2) + (s / 2);
            else
                answer = s * ((t + 1) / 2) ;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(-12, -8));
    }
}

//(b - a + 1) * (a + b) / 2
//등차수열의 공식;;