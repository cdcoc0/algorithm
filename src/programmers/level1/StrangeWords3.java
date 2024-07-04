package programmers.level1;

/* 이상한 문자 만들기 */
public class StrangeWords3 {
    private static String solution(String s) {
        StringBuffer sb = new StringBuffer();

        int ptr = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(s.charAt(i) == ' ') {
                sb.append(c);
                ptr = 0;
            } else if(ptr % 2 == 1) {
                // 홀수 (소문자)
                sb.append(Character.toLowerCase(c));
                ptr++;
            } else {
                // 짝수 (대문자)
                sb.append(Character.toUpperCase(c));
                ptr++;
            }
        }

        return sb.toString();

        /* 배열로 변환 뒤 한번에 String으로 가져오는게 성능 더 빠름 */
//        char[] chars = s.toCharArray();
//        int idx = 0;
//
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == ' ')
//                idx = 0;
//            else
//                chars[i] = (idx++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
//        }
//
//        return String.valueOf(chars);
        /* ************************************************ */
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
