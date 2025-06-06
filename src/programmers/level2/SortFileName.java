package programmers.level2;

import java.util.Arrays;

/* 파일명 정렬 */
public class SortFileName {
    private String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            int head1 = 0, head2 = 0;
            int num1 = 0, num2 = 0;
            boolean flag1 = false, flag2 = false;

            for(int i = 0; i < o1.length(); i++) {
                if(!flag1 && Character.isDigit(o1.charAt(i))) {
                    head1 = i;
                    flag1 = true;
                } else if(flag1 && !Character.isDigit(o1.charAt(i))) {
                    num1 = i;
                    break;
                }
            }

            for(int i = 0; i < o2.length(); i++) {
                if(!flag2 && Character.isDigit(o2.charAt(i))) {
                    head2 = i;
                    flag2 = true;
                } else if(flag2 && !Character.isDigit(o2.charAt(i))) {
                    num2 = i;
                    break;
                }
            }

            int comp = o1.substring(0, head1).toUpperCase().compareTo(o2.substring(0, head2).toUpperCase());
            if(comp != 0) return comp;

            if(num1 == 0) num1 = o1.length();
            if(num2 == 0) num2 = o2.length();
            return Integer.compare(Integer.parseInt(o1.substring(head1, num1)), Integer.parseInt(o2.substring(head2, num2)));
        });

        return files;
    }

    public static void main(String[] args) {
        String[] files = {"B500", "B399", "D5", "D005", "C500001", "C50000"};
        SortFileName main = new SortFileName();
        main.solution(files);
    }
}
