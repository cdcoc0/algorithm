package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortStrings {
    static String[] solution(String[] strings, int n) {
        ArrayList<String> arrayStrings = new ArrayList<>(Arrays.asList(strings));
        Collections.sort(arrayStrings);
        for(int i = 0; i < strings.length; i++) {
            for(int j = 0; j < strings.length - i - 1; j++) {
                if(arrayStrings.get(j).charAt(n) > arrayStrings.get(j + 1).charAt(n))
                    Collections.swap(arrayStrings, j, j + 1);
            }
        } //sort 함수 활용하면 훨씬 쉽게 해결 가능
        return arrayStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        System.out.println(solution(strings, 1));
    }
}

/*
ArrayList<String> arr = new ArrayList<>();
    for (int i = 0; i < strings.length; i++) {
    arr.add("" + strings[i].charAt(n) + strings[i]);
    }
n번째 알파벳을 단어의 맨 앞에 붙인 뒤 정렬, 다시 떼기
*/

/*Arrays.sort(strings);
Arrays.sort(strings, Comparator.comparing((s) -> s.substring(n, n + 1)));*/
