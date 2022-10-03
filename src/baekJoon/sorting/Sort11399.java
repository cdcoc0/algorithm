package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort11399 {

    static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    static void quickSort(int[] nums, int left, int right) {
        int pl = left;
        int pr = right;
        int x = nums[(pl + pr) / 2];

        do {
            while (nums[pl] < x) pl++;
            while (nums[pr] > x) pr--;
            if(pl <= pr) swap(nums, pl++, pr--);
        } while(pl <= pr);

        if(left < pr) quickSort(nums, left, pr);
        if(right > pl) quickSort(nums, pl, right);
    }

    public void atm() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //버블
//        int a = 0;
//        while(a < n - 1) {
//            int last = n - 1;
//            for(int j = n - 1; j > a; j--) {
//                if(nums[j] < nums[j - 1]) {
//                    swap(nums, j, j - 1);
//                    last = j;
//                }
//            }
//            a = last;
//        }

        //선택
//        for(int i = 0 ; i < n - 1; i++) {
//            int min = i;
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] < nums[min]) {
//                    min = j;
//                }
//            }
//            swap(nums, min, i);
//        }

        //삽입
//        for(int i = 1; i < n; i++) {
//            int j = i;
//            int selected = nums[i];
//            for(; j > 0 && selected < nums[j - 1]; j--) {
//                nums[j] = nums[j - 1];
//            }
//            nums[j] = selected;
//        }

        //quick
        quickSort(nums, 0, n - 1);

        int sum = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            result += sum;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        Sort11399 s = new Sort11399();
        s.atm();
    }
}
