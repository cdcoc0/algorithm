package programmers.level1;

import java.util.Arrays;

public class NoSameNum {
    static int[] solution(int []arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1])
                arr[i] = -1;
        }

        int[] answer = Arrays.stream(arr).filter(n -> n != -1).toArray();

        return answer;
    }
}
//preNum 사용하는 방법 있음