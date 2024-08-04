package programmers.level1;

/* 숫자 짝꿍 */
public class NumberPartner {
    private static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        for(int i = 9; i >= 0; i--) {
            String num = Integer.toString(i);
            String tmpX = X.replaceAll("[^"+num+"]", "");
            String tmpY = Y.replaceAll("[^"+num+"]", "");    /* ---> 속도가 매우 느림...ㅠㅠ */

            if(!tmpX.isEmpty() && !tmpY.isEmpty()) {
                if(i == 0 && sb.length() == 0) {
                    sb.append("0");
                } else {
                    int count = Math.min(tmpY.length(), tmpX.length());
                    sb.append(num.repeat(count));
                }
            }
        }

        return sb.length() == 0 ? "-1" : sb.toString();
    }

    public static void main(String[] args) {
        String x = "12321";
        String y = "42531";
        System.out.println(solution(x, y));
    }
}
