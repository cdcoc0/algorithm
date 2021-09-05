package programmers.level1;

public class ConvertToInt {
    static int solution(String s) {
        boolean a = true;
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '-')
                a = false;
            else if(c != '+') {
                result = result * 10 + (c - '0');
            }
        }

        return (a ? 1 : -1) * result;
    }

    public static void main(String[] args) {
        System.out.println(solution("-1234"));
    }
}
