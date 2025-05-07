package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/* 뉴스 클러스터링 */
public class NewsClustering {
    List<String> splitStr(String str) {
        List<String> result = new ArrayList<>();
        String regExp = "[a-z]+";
        str = str.toLowerCase();

        for(int i = 0; i < str.length() - 1; i++) {
            String cur = str.substring(i, i + 2);
            if(cur.matches(regExp)) {
                result.add(cur);
            }
        }

        return result;
    }

    int solution(String str1, String str2) {
        List<String> listStr1 = splitStr(str1);
        List<String> listStr2 = splitStr(str2);

        if(listStr1.isEmpty() && listStr2.isEmpty()) {
            return 65536;
        }

        // 교집합 / 합집합
        double union = listStr1.size() + listStr2.size();
        double intersection = 0;
        for(int i = listStr1.size() - 1; i >= 0; i--) {
            for(int j = listStr2.size() - 1; j >= 0; j--) {
                String s1 = listStr1.get(i);
                String s2 = listStr2.get(j);

                if(s1.equals(s2)) {
                    intersection++;
                    listStr1.remove(s1);
                    listStr2.remove(s2);
                    break;
                }
            }
        }

        return (int)Math.floor(intersection / (union - intersection) * 65536);
    }

    public static void main(String[] args) {
        NewsClustering main = new NewsClustering();
        String str1 = "FRANCE";
        String str2 = "french";

//        String str1 = "E=M*C^2";
//        String str2 = "e=m*c^2";

//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";

        System.out.println(main.solution(str1, str2));
    }
}
