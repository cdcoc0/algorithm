package programmers.level1;

/* 바탕화면 정리 */
public class CleanDesktopBackground {
    private static int[] solution(String[] wallpaper) {
        int len = wallpaper[0].length();
        int lux = wallpaper.length;
        int luy = len;
        int rdx = 0;
        int rdy = 0;

        for(int i = 0; i < wallpaper.length; i++) {
            String s = wallpaper[i];
            for(int j = 0; j < len; j++) {
                if(s.charAt(j) == '#') {
                    luy = Math.min(j, luy);
                    lux = Math.min(i, lux);
                    rdy = Math.max(j, rdy);
                    rdx = Math.max(i, rdx);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        String[] wallpaper = {".....", "....#"};
        solution(wallpaper);
    }
}
