package programmers.level1;

public class SumOfDivisors {
    static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                answer += i;
                if (n / i != i)
                    answer += n / i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(12));
    }
}

/*
for(int i = 1; i <= num/2; i++) {
    if(num%i == 0) answer += i;
}
return answer+num;
*/