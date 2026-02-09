package programmers.level2;

/**
 * 이진 변환 반복하기 (월간 코드 챌린지 시즌1)
 */
public class RepeatBinaryConversion {
    private int[] solution(String s) {
        int countBinaryConversion = 0;
        int countZeroRemoval = 0;

        while(!"1".equals(s)) {
            int len = s.length();
            s = s.replaceAll("0", "");

            int replacedLen = s.length();
            countZeroRemoval += len-replacedLen;
            countBinaryConversion ++;

            s = Integer.toBinaryString(replacedLen);
        }

        return new int[]{countBinaryConversion, countZeroRemoval};
    }

    public static void main(String[] args) {
        RepeatBinaryConversion main = new RepeatBinaryConversion();

        String s = "1111111";
        main.solution(s);
    }
}
