package programmers.level1;

public class NumsNEng {
    static int solution(String s) {
        String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < alphabet.length; i++) {
            s = s.replace(alphabet[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "23four5six7";
        solution(s);
    }
}
