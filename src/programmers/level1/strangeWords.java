package programmers.level1;

public class strangeWords {
    static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int i = 0; i  < s.length(); i++) {
            if (s.charAt(i) == (' ')) {
                sb.append(" ");
                idx = 0;
            }
            else {
                if(idx % 2 != 0) {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                    //여기서 계속 막힘..!
                } else {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
                idx++;
            }
        }

        System.out.println(sb);

        return sb.toString();
    }

    public static void main(String[] args) {
        solution("try hello world");
    }
}
