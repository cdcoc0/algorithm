package programmers.level1;

import java.util.*;

/* 데이터 분석 */
public class DataAnalysis {
    private static int getIdx(String value) {
        // 동적으로 구현하는 방식이 나음
        int idx = 0;

        switch(value) {
            case "date" :
                idx = 1;
                break;
            case "maximum" :
                idx = 2;
                break;
            case "remain" :
                idx = 3;
                break;
            default :
                break;
        }

        return idx;
    }
    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int idxExt = getIdx(ext);
        int idxSortBy = getIdx(sort_by);

        List<int[]> dataList = new ArrayList<>();

        for(int[] d : data) {
            if(d[idxExt] < val_ext) {
                dataList.add(d);
            }
        }

        dataList.sort(Comparator.comparingInt(o -> o[idxSortBy]));
        int[][] answer = new int[dataList.size()][];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = dataList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        solution(data, ext, val_ext, sort_by);
    }
}
