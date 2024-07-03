package programmers.level1;

import java.util.ArrayList;

public class NoSameNum2 {
    public int[] solution(int []arr) {

        ArrayList<Integer> arrResult = new ArrayList<>();
        arrResult.add(arr[0]);
        int prev = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != prev) {
                arrResult.add(arr[i]);
            }
            prev = arr[i];
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");


        return arrResult.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void mains(String[] args) {
        //
    }
}
