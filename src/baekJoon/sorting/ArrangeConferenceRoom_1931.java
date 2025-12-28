package baekJoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 회의실 배정_1931
 */
public class ArrangeConferenceRoom_1931 {
    private int countConference(Integer[][] timeTable) {
        // 최대한 많은 회의를 배정하려면 회의가 끝나는 시간이 빠른 순으로 정렬 필요
        Arrays.sort(timeTable, Comparator.comparingInt((Integer[] o) -> o[1]).thenComparingInt(o -> o[0]));

        int count = 0;
        int end = 0;
        for (Integer[] time : timeTable) {
            if (time[0] >= end) {
                count++;
                end = time[1];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        ArrangeConferenceRoom_1931 main = new ArrangeConferenceRoom_1931();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[][] timeTable = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            String[] split =  br.readLine().split(" ");
            timeTable[i][0] = Integer.parseInt(split[0]);
            timeTable[i][1] = Integer.parseInt(split[1]);
        }

        System.out.println(main.countConference(timeTable));
    }
}
