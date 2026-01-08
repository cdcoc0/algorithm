package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 강의실 배정_11000
 */
public class AssignClassroom_11000 {
    private void greedy(int N, String[][] timeTable) {
        //
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AssignClassroom_11000 main = new AssignClassroom_11000();

        int N = Integer.parseInt(br.readLine());
        String[][] timeTable = new String[N][];
        for(int i = 0; i < N; i++) {
            timeTable[i] = br.readLine().split(" ");
        }

        main.greedy(N, timeTable);
    }
}
