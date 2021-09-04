package programmers.level1;

public class CaesarCipher {
    static String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int cnt = s.charAt(i) + n;
            if(s.charAt(i) == 32)
                sb.append(" ");
            else if (s.charAt(i) <= 90) {
                if(cnt > 90)
                    sb.append((char)('a' + (cnt - 90 - 1 - 32)));
                else
                    sb.append((char)cnt);
            } else {
                if(cnt > 122)
                    sb.append((char)('a' + (cnt - 122 - 1)));
                else
                    sb.append((char)cnt);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("AB", 25));
    }
}
