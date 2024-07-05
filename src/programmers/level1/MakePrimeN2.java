package programmers.level1;

/* 소수 만들기 */
public class MakePrimeN2 {
    private static boolean[] prime(int num) {
        boolean[] result = new boolean[num + 1];

        result[0] = true;
        result[1] = true;

        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(!result[i]) {
                for(int j = i + i; j <= num; j += i) {
                    result[j] = true;
                }
            }
        }

        return result;
    }
    private static int solution(int[] nums) {
        int answer = 0;

        boolean[] prime = prime(1000 + 999 + 998);

        for(int i = 0; i <= nums.length-3; i++) {
            for(int j = i + 1; j <= nums.length-2; j++) {
                for(int k = j + 1; k <= nums.length-1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(!prime[sum]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }
}
