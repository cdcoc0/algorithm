package programmers.level2;

/* Jaden Case 문자열 만들기 */
public class MakeJadenCaseString {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        int idx = s.indexOf(" ");

        while(!s.isEmpty()) {
            char first = s.charAt(0);
            if(first >= 'a' && first <= 'z') s = s.replaceFirst(String.valueOf(first), String.valueOf(first).toUpperCase());

            if(idx < 0) {
                sb.append(s);
                break;
            }

            sb.append(s.substring(0, idx + 1));
            s = s.substring(idx + 1);

            idx = s.indexOf(" ");
        }

        return sb.toString();

        // split 쓸거면 마지막 문자가 공백인 경우 임의 문자 추가 & 리턴할 때 제거 로직만 추가하면 될 듯
    }

    public static void main(String[] args) {
        MakeJadenCaseString main = new MakeJadenCaseString();
        String s = "  for the what  1what  ";
        System.out.println(main.solution(s));
    }
}
