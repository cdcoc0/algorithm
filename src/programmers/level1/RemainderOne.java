package programmers.level1;

public class RemainderOne {
//    static boolean[] get_prime() {
//        boolean[] prime = new boolean[1001];
//        prime[0] = prime[1] = true;
//        for(int i = 2; i < prime.length; i++) {
//            if(prime[i] == true) continue;
//            for(int j = i + i; j < prime.length; j += i) {
//                prime[j] = true;
//            }
//        }
//        return prime;
//    }

    static int solution(int n) {
//        int answer = 0;

        if(n % 2 != 0)
            return 2;
        else {
            for(int i = 3; i <= Math.sqrt(n - 1); i += 2) {
                if((n - 1) % i == 0)
                    return i;
            }
        }

        return n - 1;

//        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
