package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IntArray {
    static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(n -> n % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[] {-1};

        Arrays.sort(answer);
        return answer;

        /*ArrayList<Integer> intArray = new ArrayList<>();
        for(int n : arr) {
            if(n % divisor == 0)
                intArray.add(n);
        }
        if(intArray.size() == 0)
            return new int[] {-1};

        intArray.sort(Comparator.naturalOrder());
        int[] answer = new int[intArray.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = intArray.get(i).intValue();

        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;*/
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 6};
        System.out.println(solution(arr, 10));
    }
}

//Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
//"Array.stream"