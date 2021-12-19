package programmers.level1;

public class Pokemon {
    static int solution(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n / 2];
        int ptr = 0;

        for(int i = 0; i < n; i++) {
            int checkCnt = 0;
            for(int j = 0; j < ptr; j++) {
                if(nums[i] == cnt[j])
                    break;
                checkCnt++;
            }
            if(checkCnt == ptr) {
                cnt[ptr++] = nums[i];
            }
            checkCnt = 0;

            if(ptr >= n / 2)
                break;
        }
       return ptr;

        /**
            Arrays.sort(nums);

            int cnt=1;
            int num=nums[0];

            for(int i=1; i<nums.length; i++){
                if(nums[i]!=num){
                    cnt++;
                    num=nums[i];
                }
            }

            return cnt<nums.length/2? cnt:nums.length/2;
        */
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(nums));
    }
}
