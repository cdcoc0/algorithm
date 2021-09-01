package programmers.level1;

import java.util.Locale;

public class StrangeWords2 {
    static String solution(String s) {
        String[] str = s.split("");
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i].charAt(0) == ' ') {
                sb.append(" ");
                idx = 0;
            } else if(idx % 2 != 0) {
                sb.append(str[i].toLowerCase());
                idx++;
            } else {
                sb.append(str[i].toUpperCase());
                idx++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
