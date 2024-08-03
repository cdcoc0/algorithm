package programmers.level1;

/* 숫자 문자열과 영단어 */
public class NumStringAndEng2 {
    private static int solution(String s) {
        String convert = s;

        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < nums.length; i++) {
            convert = convert.replaceAll(nums[i], String.valueOf(i));
        }

        return Integer.parseInt(convert);
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }
}
