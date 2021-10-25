package programmers.level1;

public class MinSquare {
    static int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < sizes.length; i++) {
            int s1 = Math.max(sizes[i][0], sizes[i][1]);
            int s2 = Math.min(sizes[i][0], sizes[i][1]);

            max1 = s1 > max1 ? s1 : max1;
            max2 = s2 > max2 ? s2 : max2;
        }

        return max1 * max2;
    }

    public static void main(String[] args) {
        int[][] s = {{10, 7}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(s));
    }
}
