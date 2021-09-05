package programmers.level1;

public class PrimeNum {

    static boolean[] prime(int n) {
        boolean[] p = new boolean[n + 1];
        p[0] = true;
        p[1] = true;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(p[i] == true) continue;
            for(int j = i + i; j <= n; j += i)
                p[j] = true;
        }
        return p;
    }

    static int solution(int n) {
        int answer = 0;
        boolean[] p = prime(n);
        for(int i = 2; i <= n; i++) {
            if(p[i] == false)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
