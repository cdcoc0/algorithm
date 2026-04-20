package programmers.level2;

/**
 * 2개 이하로 다른 비트 (월간 코드 챌린지 시즌2)
 */
public class DifferentBits {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] result = Solution.solution(numbers);
        for(long a : result) System.out.println(a);
    }

    static class Solution {
        static public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i = 0; i < numbers.length; i++) {
                long tmp = numbers[i];
                String binary = Long.toBinaryString(tmp);
                String binary2 = binary;

                if(tmp % 2 == 0) {
                    answer[i] = tmp+1;
                    continue;
                }

                binary = "0" + binary;
                for(int j = binary.length()-1; j >= 0; j--) {
                    if(binary.charAt(j) == '0') {
                        binary2 = binary.substring(0, j) + "10" + binary.substring(j+2);
                        break;
                    }
                }

                answer[i] = Long.parseLong(binary2, 2);
            }

            return answer;
        }
    }
}
