package programmers.level1;

import java.util.Arrays;

public class Pokemon2 {
    static public int solution(int[] nums) {
        int answer = 0;

        int num = nums.length/2;

        int[] distinct = Arrays.stream(nums).distinct().toArray();
        answer = Math.min(distinct.length, num);

        return answer;


//        return Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.collectingAndThen(Collectors.toSet(),
//                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        solution(nums);
    }
}
