package programmers.level2;

/**
 * 거리두기 확인하기 (2021 카카오 채용연계형 인턴십)
 */
public class ValidateSocialDistances {
    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Solution.solution(places);
//        "POOOP",
//        "OXXOX",
//        "OPXPX",
//        "OOXOX",
//        "POXXP"
    }

    static class Solution {
        static int[] solution(String[][] places) {
            int[] answer = new int[5];
            final char PERSON = 'P';
            final char EMPTY = 'O';
            final char PARTITION = 'X';

            for(int i = 0; i < places.length; i++) {
                System.out.println("places[" + i + "] START");
                answer[i] = 1;
                String[] place = places[i];
                int[][] coords = new int[4][2];
                for(int j = 0; j < 5; j++) {
                    System.out.println("places[" + i + "] : [" + j + "] START");
                    for(int k = 0; k < 5; k++) {
                        System.out.println("places[" + i + "] : [" + j + "][" + k + "] START");
                        if(place[j].charAt(k) == PERSON) {
                            System.out.println(j + " : " + k + " | PERSON detected");
                            char up = j > 0 ? place[j-1].charAt(k) : PARTITION;
                            char down = j < 4 ? place[j+1].charAt(k) : PARTITION;
                            char right = k < 4 ? place[j].charAt(k+1) : PARTITION;
                            char left = k > 0 ? place[j].charAt(k-1) : PARTITION;
                            System.out.println("up : " + up + " down : " + down + " right : " + right + " left : " + left);

                            if(up == PERSON || down == PERSON || left == PERSON || right == PERSON) {
                                System.out.println("!!!!! PERSON detected in the same row or column");
                                answer[i] = 0;
                                break;
                            }

                            int idx = 0;

                            // 위
                            if(up == EMPTY) {
                                coords[idx][0] = j-1;
                                coords[idx++][1] = k;
                            }

                            // 아래
                            if(down == EMPTY) {
                                coords[idx][0] = j+1;
                                coords[idx++][1] = k;
                            }

                            // 오
                            if(right == EMPTY) {
                                coords[idx][0] = j;
                                coords[idx++][1] = k+1;
                            }

                            // 왼
                            if(left == EMPTY) {
                                coords[idx][0] = j;
                                coords[idx++][1] = k-1;
                            }

                            for(int l = 0; l < idx; l++) {
                                int row = coords[l][0];
                                int col = coords[l][1];

                                // 위
                                if(row > 0 && place[row-1].charAt(col) == PERSON && row-1 != j) {
                                    System.out.println("!!!!!PERSON detected in UP");
                                    answer[i] = 0;
                                    break;
                                }

                                // 아래
                                if(row < 4 && place[row+1].charAt(col) == PERSON && row+1 != j) {
                                    System.out.println("!!!!!PERSON detected in DOWN");
                                    answer[i] = 0;
                                    break;
                                }

                                // 오
                                if(col < 4 && place[row].charAt(col+1) == PERSON && col+1 != k) {
                                    System.out.println("!!!!!PERSON detected in RIGHT");
                                    answer[i] = 0;
                                    break;
                                }

                                // 왼
                                if(col > 0 && place[row].charAt(col-1) == PERSON && col-1 != k) {
                                    System.out.println("!!!!!PERSON detected in LEFT");
                                    answer[i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                    if(answer[i] == 0) break;
                }
            }

            for(int a : answer) {
                System.out.println(a);
            }

            return answer;
        }
    }
}
