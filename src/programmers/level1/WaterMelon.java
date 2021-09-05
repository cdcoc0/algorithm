package programmers.level1;

public class WaterMelon {
    static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(i % 2 != 0)
                sb.append("수");
            else
                sb.append("박");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
