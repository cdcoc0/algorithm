package programmers.level1;

public class orderDesc {
    static void swap(long[] a, int idx1, int idx2) {
        long t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static long solution(long n) {
        long[] nums = new long[10];
        int i = 0;
        while(n > 0) {
            nums[i++] = n % 10;
            n /= 10;
        }
        for(int j = 0; j < i; j++) {
            for(int k = j + 1; k < i; k++){
                if(nums[j] < nums[k]) {
                    swap(nums, j, k);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < i; j++){
            sb.append(nums[j]);
        }
        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
