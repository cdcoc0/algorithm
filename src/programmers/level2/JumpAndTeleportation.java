package programmers.level2;

/* 점프와 순간이동 */
public class JumpAndTeleportation {
    public int solution(int n) {
        int ans = 0;

        while(n > 1) {
            if(n % 2 == 1) {
                n -= 1;
                ans++;
            }

            n /= 2;
        }

        return ans + 1;
        //Integer.bitCount(n)
    }

    public static void main(String[] args) {
        int n = 5;

        JumpAndTeleportation main = new JumpAndTeleportation();
        System.out.println(main.solution(n));
    }
}
