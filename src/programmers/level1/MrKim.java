package programmers.level1;

public class MrKim {
    static String solution(String[] seoul) {
        int idx = 0;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }
        String answer = String.format("김서방은 %d에 있다", idx);
        //"김서방은 " + idx + "에 있다";
        return answer;
    }

    public static void main(String[] args) {
        String[] seoul = {"Jane" , "Kim"};
        System.out.println(solution(seoul));
    }
}
