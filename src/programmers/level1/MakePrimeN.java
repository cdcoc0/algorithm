package programmers.level1;

public class MakePrimeN {

    static boolean isPrime(int n) {
        if(n < 2)
            return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return true;
            }
        }

        return false;
    }

    static boolean[] getPrime(int n) {
        boolean[] prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i] == true) {
                continue;
            }

            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        return prime;
    }

    static int solution(int[] nums) {
        int answer = 0;

        boolean[] prime = getPrime(3000);

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(prime[sum] == false) {
                        System.out.println(sum);
                        answer++;
                    }
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};

        System.out.println(solution(nums));
    }
}
