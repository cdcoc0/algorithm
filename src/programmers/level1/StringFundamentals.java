package programmers.level1;

public class StringFundamentals {
    static boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) - '0' > 9) {
                    return false;
                }
            }
        }
        else
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }
}

/*if(s.length() == 4 || s.length() == 6){
    try{
        int x = Integer.parseInt(s);
        return true;
    } catch(NumberFormatException e){
        return false;
        }
    }
else return false;*/
