package programmers.level1;

public class gcdNlcm {
    static int recursive(int max , int min) {
        if(min == 0)
            return max;
        else
            return recursive(min, max % min);
    }

    static int[] solution(int n, int m) {
        int gcd = 1;
        int lcm = 0;
        int max = Math.max(n, m);
        int min = Math.min(n, m);

        if(max % min == 0) {
            gcd = min;
            lcm = max;
        } else {
//            for(int i = 1; i <= min; i++) {
//                if(n % i == 0 && m % i == 0)
//                    gcd = i;
//            }
            gcd = recursive(max, min);
            lcm = gcd * (min / gcd) * (max / gcd);
//            for(int i = 2; i <= min; i++) {
//                if((max * i) % min == 0) {
//                    lcm = max * i;
//                    break;
//                }
//            }
        }

        int[] answer = {gcd, lcm};
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }

    public static void main(String[] args) {
        solution(11, 12);
    }
}
