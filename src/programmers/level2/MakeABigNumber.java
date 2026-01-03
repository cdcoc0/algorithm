package programmers.level2;

/**
 * 큰 수 만들기 (탐욕법, Greedy)
 */
public class MakeABigNumber {
    private String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int i = 0;
        while(k > 0 && i < sb.length()-1) {
            if(sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i = Math.max(0, i-1);
                k--;
            } else {
                i++;
            }
        }

        return sb.substring(0, sb.length()-k);
    }

    public static void main(String[] args) {
        MakeABigNumber main = new MakeABigNumber();

        String number = "4177252841";
        int k = 4;
        main.solution(number, k);
    }
}
