package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/* 체육복 */
public class SweatSuit {
    private static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for(int lo : lost) {
            lostList.add(lo);
        }

        for(int res : reserve) {
            reserveList.add(res);
        }

        for(int i = lostList.size()-1; i >= 0; i--) {
            Integer value = lostList.get(i);
            if(reserveList.contains(value)) {
                lostList.remove(value);
                reserveList.remove(value);
            }
        }

        lostList.sort(Integer::compareTo);
        for(int i = lostList.size()-1; i >= 0; i--) {
            int lostNum = lostList.get(i);
            if(reserveList.contains(lostNum+1)) {
                lostList.remove(i);
                reserveList.remove(Integer.valueOf(lostNum+1));
            } else if(reserveList.contains(lostNum-1)) {
                lostList.remove(i);
                reserveList.remove(Integer.valueOf(lostNum-1));
            }
        }

        return n - lostList.size();
    }

    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }
}
