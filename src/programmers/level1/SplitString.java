package programmers.level1;

/* 문자열 나누기 */
public class SplitString {
    private static int solution(String s) {
        int answer = 0;
        String[] split = s.split("");

        String x = "";
        int cntX = 0;
        int nonX = 0;

        for(String str : split) {
            if(x.isEmpty()) {
                x = str;
                answer++;
            }

            if(str.equals(x)) {
                cntX++;
            } else {
                nonX++;
            }

            if(cntX == nonX) {
                x = "";
                cntX = 0;
                nonX = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        System.out.println(solution(s));
    }
}
