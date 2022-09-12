package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sort2750 {

//    N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//    첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

    static void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    static void quickSort(int[] n, int left, int right) {
        int pl = left;
        int pr = right;
        int x = n[(pl + pr) / 2];

        do {
            while(n[pl] < x) pl++;
            while(n[pr] > x) pr--;

            if(pr >= pl) swap(n, pl++, pr--);
        } while(pr >= pl);

        if(left < pr) quickSort(n, left, pr);
        if(pl < right) quickSort(n, pl, right);
    }

    public void sort() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        //quick
        quickSort(nums, 0, n - 1);

        for(int num : nums) {
            System.out.println(num);
        }

        //버블
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
//
//        for(int num : nums) {
//            System.out.println(num);
//        }

        //선택
//        for(int i = 0; i < n - 1; i++) {
//            int min = i;
//            for(int j = n - 1; j > i; j--) {
//                if(nums[j] < nums[min])
//                    min = j;
//            }
//            swap(nums, min, i);
//        }
//
//        for(int num : nums) {
//            System.out.println(num);
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
//
//        for(int num : nums) {
//            System.out.println(num);
//        }
    }
    public static void main(String[] args) throws IOException {
        Sort2750 s = new Sort2750();
        s.sort();
    }
}
