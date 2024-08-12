package programmers.level1;

/* 기사단원의 무기 */
public class WeaponsOfTheOrder {
    private static int solution(int number, int limit, int power) {
        int answer = 0;

        int[] divisor = new int[number + 1];
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                divisor[i * j]++;
            }
        }

//        for(int i = 2; i < divisor.length; i++) {
//            int cnt = 2;
//            for(int j = 2; j <= Math.sqrt(i); j++) {
//                if(i % j == 0) {
//                    cnt++;
//                    if(j != i / j) {
//                        cnt++;
//                    }
//                }
//            }
//            divisor[i] = cnt > limit ? power : cnt;
//        }

        for(int d : divisor) {
            answer += d > limit ? power : d;
        }

        return answer;
    }

    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power));
    }
}
