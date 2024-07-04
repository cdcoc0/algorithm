package programmers.level1;

/* 시저 암호 */
public class CaesarCipher2 {
    private static String solution(String s, int n) {
        int a = 'a';
        int z = 'z';

        int A = 'A';
        int Z = 'Z';

        int blank = ' ';

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            if(c == blank) {
                // blank
                sb.append(Character.toChars(c));
            }
            else if (c >= a && c <= z) {
                // 소문자
                sb.append(Character.toChars(c + n > z ? a + (c + n - z) - 1: c + n));
            } else if (c >= A && c <= Z) {
                // 대문자
                sb.append(Character.toChars(c + n > Z ? A + (c + n - Z) - 1: c + n));
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        solution("a B z", 4);
        System.out.println('c' % 26);
    }
}
