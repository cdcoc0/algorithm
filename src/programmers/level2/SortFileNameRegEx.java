package programmers.level2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 파일명 정렬 */
public class SortFileNameRegEx {
    private String[] solution(String[] files) {
        Pattern p = Pattern.compile("([A-Z\\s.-]+)([0-9]{1,5})");
        Arrays.sort(files, (o1, o2) -> {
            // Pattern, Matcher
            Matcher m1 = p.matcher(o1.toUpperCase());
            Matcher m2 = p.matcher(o2.toUpperCase());
            boolean chk1 = m1.find(), chk2 = m2.find();

            int head = m1.group(1).compareTo(m2.group(1));
            if(head != 0) return head;

            return Integer.compare(Integer.parseInt(m1.group(2)), Integer.parseInt(m2.group(2)));
        });

        return files;
    }

    public static void main(String[] args) {
//        String[] files = {"B500", "B399", "D5", "D005", "C500001", "C50000"};
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        SortFileNameRegEx main = new SortFileNameRegEx();
        main.solution(files);
    }
}
