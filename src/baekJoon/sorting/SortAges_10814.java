package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 나이순 정렬
 */
public class SortAges_10814 {
    private String sort(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, Comparator.comparingInt((String[] o) -> Integer.parseInt(o[0])));

        for(String[] s : arr) {
            sb.append(s[0]).append(" ").append(s[1]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        SortAges_10814 main = new SortAges_10814();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];
        for(int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = split[0];
            arr[i][1] = split[1];
        }

        System.out.println(main.sort(arr));
    }
}
