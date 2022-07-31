package programmers.level1;

public class Keypad {
    static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int l = 10;
        int r = 12;

        for(int number : numbers) {
            switch(number) {
                case 1: case 4: case 7:
                    sb.append("L");
                    l = number;
                    break;
                case 3: case 6: case 9:
                    sb.append("R");
                    r = number;
                    break;
                default:
                    //1, 3
                    //2, 4, 6
                    //5, 7, 9
                    //8, 10
                    if(number == 0) {
                        number = 11;
                    }

                    int fromR = Math.abs(number - r);
                    int fromL = Math.abs(number - l);

                    if(fromR == 0) {
                        sb.append("R");
                        r = number;
                    } else if(fromR == 1 || fromR == 3) {
                        switch(fromL) {
                            case 0:
                                sb.append("L");
                                l = number;
                                break;
                            case 1: case 3:
                                if(hand.equals("right")) {
                                    sb.append("R");
                                    r = number;
                                } else {
                                    sb.append("L");
                                    l = number;
                                }
                                break;
                            default:
                                sb.append("R");
                                r = number;
                                break;
                        }
                    } else if(fromR == 2 || fromR == 4 || fromR == 6) {
                        switch(fromL) {
                            case 0: case 1: case 3:
                                sb.append("L");
                                l = number;
                                break;
                            case 2: case 4: case 6:
                                if(hand.equals("right")) {
                                    sb.append("R");
                                    r = number;
                                } else {
                                    sb.append("L");
                                    l = number;
                                }
                                break;
                            default:
                                sb.append("R");
                                r = number;
                                break;
                        }
                    } else if(fromR == 5 || fromR == 7 || fromR == 9) {
                        switch(fromL) {
                            case 8: case 10:
                                sb.append("R");
                                r = number;
                                break;
                            case 5: case 7: case 9:
                                if(hand.equals("right")) {
                                    sb.append("R");
                                    r = number;
                                } else {
                                    sb.append("L");
                                    l = number;
                                }
                                break;
                            default:
                                sb.append("L");
                                l = number;
                                break;
                        }
                    } else if(fromR == 8 || fromR == 10) {
                        switch (fromL) {
                            case 8: case 10:
                                if(hand.equals("right")) {
                                    sb.append("R");
                                    r = number;
                                } else {
                                    sb.append("L");
                                    l = number;
                                }
                                break;
                            default:
                                sb.append("L");
                                l = number;
                                break;
                        }
                    }

                    break;
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        Keypad k = new Keypad();
        k.solution(numbers, hand);
    }
}

//좌표 혹은 더 효율적인 계산식 생성