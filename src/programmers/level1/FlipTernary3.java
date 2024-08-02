package programmers.level1;

/* 3진법 뒤집기 */
public class FlipTernary3 {
    private static int solution(int n) {
        String ternary = Integer.toString(n, 3);
        String[] split = ternary.split("");

        StringBuilder sb = new StringBuilder();

        for(int i = split.length-1; i >= 0; i--) {
            sb.append(split[i]);
        }

        return Integer.parseInt(sb.toString(), 3);
    }
    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }
}
