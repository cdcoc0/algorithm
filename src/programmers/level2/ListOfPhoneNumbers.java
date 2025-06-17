package programmers.level2;

import java.util.Arrays;

/* 전화번호 목록 */
public class ListOfPhoneNumbers {
    private boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {return false;}
        }

        return true;
    }

    public static void main(String[] args) {
        ListOfPhoneNumbers main = new ListOfPhoneNumbers();

        String[] phone_book = {"123", "456", "789"};
        main.solution(phone_book);
    }
}
