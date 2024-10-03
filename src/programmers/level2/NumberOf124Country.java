package programmers.level2;

/* 124 나라의 숫자 */
public class NumberOf124Country {
    private static String solution(int n) {
        StringBuilder answer = new StringBuilder();

        int[] nums = {4, 1, 2};
        int tmp = 3;

        while(n > 0) {
            int remain = n % tmp;

            if(remain > 0 && remain <= tmp / 3) {
                answer.insert(0, nums[1]);
            } else if (remain > 0 && remain <= tmp / 3 * 2) {
                answer.insert(0,nums[2]);
            } else {
                answer.insert(0, nums[0]);
            }

            n -= tmp;
            tmp *= 3;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(14));
    }
}
