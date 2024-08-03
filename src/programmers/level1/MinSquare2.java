package programmers.level1;

/* 최소직사각형 */
public class MinSquare2 {
    private static int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;

        for(int[] s : sizes) {
            int w = Math.max(s[0], s[1]);
            int h = Math.min(s[0], s[1]);

            if(w > wMax) {
                wMax = w;
            }

            if(h > hMax) {
                hMax = h;
            }
        }

        return wMax * hMax;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes));
    }
}
