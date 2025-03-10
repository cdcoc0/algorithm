package programmers.level2;

/* N-Queen */
public class NQueen {
    int cnt = 0;
    int n;
    int[] check;

    private boolean validate(int level, int cur) {
        if(level > 0) {
            for(int j = 1; j <= level; j++) {
                if(check[level - j] == cur || check[level - j] == cur - j || check[level - j] == cur + j) return false;
            }
        }

        return true;
    }

    private void dfs(int level) {
        if(level == n) {
            cnt++;
        } else {
            for(int i = 0; i < n; i++) {
                if(validate(level, i)) {
                    check[level] = i;
                    dfs(level + 1);
                    check[level] = 0;
                }
            }
        }
    }

    private int solution(int n) {
        this.n = n;
        this.check = new int[n];

        this.dfs(0);

        System.out.println(cnt);

        return cnt;
    }

    public static void main(String[] args) {
        int n = 4;

        NQueen main = new NQueen();
        main.solution(n);
    }
}
