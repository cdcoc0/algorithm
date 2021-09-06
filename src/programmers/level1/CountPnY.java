package programmers.level1;

import java.util.Locale;

public class CountPnY {
    static boolean solution(String s) {
        int cnt = 0;
        s = s.toUpperCase();
        for(int i = 0; i < s.length(); i++) {
            char ic = s.charAt(i);
            if(ic == 'p')
                cnt++;
            else if(ic == 'Y')
                cnt--;
        }

        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }
}

//s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();