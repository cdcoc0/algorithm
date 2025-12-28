package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 좌표 정렬하기_11650
 */
public class SortCoordinates_11650 {
    private String sort(Integer[][] arr) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, Comparator.comparingInt((Integer[] o) -> o[0]).thenComparingInt(o -> o[1]));

        for(Integer[] i : arr) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        SortCoordinates_11650 main = new SortCoordinates_11650();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[][] coords = new Integer[N][2];
        for(int i = 0; i < N; i++) {
            String[] tmp =  br.readLine().split(" ");
            coords[i][0] = Integer.parseInt(tmp[0]);
            coords[i][1] = Integer.parseInt(tmp[1]);
        }

        System.out.println(main.sort(coords));
    }
}
