package programmers.level1;

import java.util.Arrays;

/* 다트 게임 */
public class DartGame2 {
    private static int solution(String dartResult) {
        /* Character.isDigit | Character.isLetter 함수 참고 */

        String num = dartResult.replaceAll("[^0-9]", ",");
        String[] nums = num.split(",");
        String[] score = Arrays.stream(nums).filter(sc -> !"".equals(sc)).toArray(String[]::new);

        int[] calc = new int[3];
        dartResult += " ";

        for(int i = 0; i < score.length; i++) {
            char secondChar = dartResult.charAt(score[i].length());
            char thirdChar = dartResult.charAt(score[i].length() + 1);

            int sqr = secondChar == 'S' ? 1 : secondChar == 'D' ? 2 : 3;
            int opt = thirdChar == '#' ? -1 : thirdChar == '*' ? 2 : 1;

            calc[i] = ((int) Math.pow(Integer.parseInt(score[i]), sqr)) * opt;

            if(i > 0 && opt == 2) {
                calc[i - 1] *= opt;
            }

            String sReplace = score[i] + secondChar + (opt == 1 ? "" : thirdChar);
            dartResult = dartResult.replace(sReplace, "");
        }

        return calc[0] + calc[1] + calc[2];
    }
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }
}



//public class Solution {
//    static int[] sum = new int[3];
//    static int solution(String msg){
//        String reg = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
//        Pattern p = Pattern.compile(reg+reg+reg);
//        Matcher m = p.matcher(msg);
//        m.find();
//        for(int i=1; i<=m.groupCount(); i++){
//            Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
//            Matcher m1 = p1.matcher(m.group(i));
//            m1.find();
//            sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), getpow(m1.group(2)));
//            setting(i,m1.group(3));
//        }
//        return(sum[0]+ sum[1]+ sum[2]);
//    }
//    static void setting(int idx, String msg){
//        if(msg.equals("*")){
//            sum[idx - 1] *= 2;
//            if(idx > 1 ){
//                sum[idx - 2] *=2;
//            }
//        }
//        else if(msg.equals("#")){
//            sum[idx - 1] *=-1 ;
//        }
//    }
//    static int getpow(String mag){
//        if(mag.equals("S")){
//            return 1;
//        }
//        else if(mag.equals("D")){
//            return 2;
//        }
//        else {
//            return 3;
//        }
//
//    }
//}