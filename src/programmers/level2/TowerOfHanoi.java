package programmers.level2;

/* 하노이의 탑 */
public class TowerOfHanoi {
    static int[][] answer;
    static int ptr;

    private void hanoi(int n, int x, int y) {
        if(n > 1)
            hanoi(n - 1, x, 6 - x - y);

        answer[ptr][0] = x;
        answer[ptr][1] = y;
        ptr++;

        if(n > 1)
            hanoi(n - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        answer = new int[(int)Math.pow(2, 3) - 1][2];
        ptr = 0;

        TowerOfHanoi tower = new TowerOfHanoi();
        tower.hanoi(3, 1, 3);
    }
}
