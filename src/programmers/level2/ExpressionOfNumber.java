package programmers.level2;

/* 숫자의 표현 */
public class ExpressionOfNumber {
    static int solution(int n) {
        int answer = 0;

        int ptr = n / 2;
        if(n > 2) { ptr++; }

        while(true) {
            int sum = 0;
            for(int i = ptr; i >= 1; i--) {
                sum += i;
                if(sum >= n) { break; }
            }

            if( sum < n ) { break; }
            else {
                ptr--;
                if(sum == n) { answer++; }
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(solution(n));
    }
}
