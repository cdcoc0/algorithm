package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort2751 {

    static void swap(int[] n, int idx1, int idx2) {
        int tmp = n[idx1];
        n[idx1] = n[idx2];
        n[idx2] = tmp;
    }

    static void quick(int[] nums, int left, int right) {
        int pl = left;
        int pr = right;
        int x = nums[(pl + pr) / 2];

        do {
            while(nums[pl] < x) pl++;
            while(nums[pr] > x) pr--;

            if(pl <= pr) swap(nums, pl++, pr--);
        } while(pl <= pr);

        if(left < pr) quick(nums, left, pr);
        if(right > pl) quick(nums, pl, right);
    }

    public void sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        //버블
//        for(int i = 0; i < n; i++) {
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] < nums[j - 1]) {
//                    swap(nums, j, j - 1);
//                }
//            }
//        }

        //버블2
//        int i = 0;
//        int last = n - 1;
//        while(i < n - 1) {
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] < nums[j - 1]) {
//                    swap(nums, j, j - 1);
//                    last = j;
//                }
//            }
//            i = last;
//        }

        //선택
//        for(int i = 0 ; i < n; i++) {
//            int min = i;
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] < nums[min]) {
//                    min = j;
//                }
//            }
//            swap(nums, i, min);
//        }

        //삽입
//        for(int i = 1; i < n; i++) {
//            int j = i;
//            int tmp = nums[i];
//            for(; j > 0 && tmp < nums[j - 1]; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[j] = tmp;
//        }

        //quick
        quick(nums, 0, n - 1);

        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws IOException {
        Sort2751 s = new Sort2751();
        s.sort();
    }
}
