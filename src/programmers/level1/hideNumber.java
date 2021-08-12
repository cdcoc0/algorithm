package programmers.level1;

public class hideNumber {
    static String hide(String phone_number) {
        StringBuilder sb = new StringBuilder(phone_number);
        for(int i = 0; i < phone_number.length() - 4; i++) {
            sb.setCharAt(i, '*');
        }
        String answer = sb.toString();
        return answer;
    }

    /*
        char[] ch = phone_number.toCharArray();
         for(int i = 0; i < ch.length - 4; i ++){
             ch[i] = '*';
         }
        return String.valueOf(ch);
    */
    public static void main(String[] args) {
        System.out.println(hide("01033334444"));
    }
}
