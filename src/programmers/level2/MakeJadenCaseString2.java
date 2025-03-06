package programmers.level2;

public class MakeJadenCaseString2 {
    public String solution(String s) {
        s = s.toLowerCase();
        if(s.endsWith(" ")) {
            s += "|";
        }

        String[] split = s.split(" ");
        for(int i = 0; i < split.length; i++) {
            if(!split[i].isEmpty() && split[i].charAt(0) >= 'a' && split[i].charAt(0) <= 'z') {
                String first = split[i].charAt(0) + "";
                split[i] = split[i].replaceFirst(first, first.toUpperCase());
            }
        }

        return String.join(" ", split).replace("|", "");
    }

    public static void main(String[] args) {
        MakeJadenCaseString2 main = new MakeJadenCaseString2();
        String s = "  for the what  1what  ";
        System.out.println(main.solution(s));
    }
}