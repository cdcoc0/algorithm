package programmers.level1;

import java.util.Arrays;

/* 키패드 누르기 */
public class KeyPad2 {
    private static int getDistance(int tmp) {
        switch(tmp) {
            case 2: case 4:
                return 2;

            case 5: case 7:
                return 3;

            case 8: case 10:
                return 4;

            default :
                return 1;
        }
    }
    private static String solution(int[] numbers, String hand) {
        // 좌표를 사용하는 방식도 있음

        int left = 10;
        int right = 12;

        StringBuilder sb = new StringBuilder();
        for(int num : numbers) {
            switch(num) {
                case 1: case 4: case 7:
                    sb.append("L");
                    left = num;
                    break;

                case 3: case 6: case 9:
                    sb.append("R");
                    right = num;
                    break;

                default :
                    if(num == 0) {
                        num += 11;
                    }

                    int lDist = 0;
                    int rDist = 0;

                    if(left == 1 || left == 4 || left == 7 || left == 10) {
                        lDist = getDistance(Math.abs(num - left));
                    } else {
                        lDist = Math.abs(num - left) / 3;
                    }

                    if(right == 3 || right == 6 || right == 9 || right == 12) {
                        rDist = getDistance(Math.abs(num - right));
                    } else {
                        rDist = Math.abs(num - right) / 3;
                    }

                    if(lDist < rDist) {
                        sb.append("L");
                        left = num;
                    } else if (rDist < lDist) {
                        sb.append("R");
                        right = num;
                    } else {
                        if("left".equals(hand)) {
                            sb.append("L");
                            left = num;
                        } else {
                            sb.append("R");
                            right = num;
                        }
                    }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(solution(numbers, hand));
    }
}
