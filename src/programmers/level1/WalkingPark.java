package programmers.level1;

/* 공원 산책 */
public class WalkingPark {
    private static int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();
        int curH = 0;
        int curW = 0;

        for(int i = 0; i < height; i++) {
            if(park[i].contains("S")) {
                curH = i;
                curW = park[i].indexOf('S');
                break;
            }
        }

        for(String route : routes) {
            String[] split = route.split(" ");
            String direction = split[0];
            int distance = Integer.parseInt(split[1]);

            StringBuilder sb = new StringBuilder();

            switch (direction) {
                case "E" :
                    if(curW + distance >= width) {
                        continue;
                    }

                    sb.append(park[curH], curW+1, curW+distance+1);
                    if(!sb.toString().contains("X")) {
                        curW += distance;
                        sb.setLength(0);
                    }

                    break;
                case "W" :
                    if(distance > curW) {
                        continue;
                    }

                    sb.append(park[curH], curW - distance, curW);
                    if(!sb.toString().contains("X")) {
                        curW -= distance;
                        sb.setLength(0);
                    }

                    break;
                case "S" :
                    if(distance + curH >= height) {
                        continue;
                    }

                    for(int i = curH + 1; i <= curH + distance; i++) {
                        if('X' != park[i].charAt(curW)) {
                            sb.append(park[i].charAt(curW));
                        } else {
                            sb.setLength(0);
                            break;
                        }
                    }

                    if(sb.length() > 0) {
                        curH += distance;
                    }

                    break;
                case "N" :
                    if(distance > curH) {
                        continue;
                    }

                    for(int i = curH - 1; i >= curH - distance; i--) {
                        if('X' != park[i].charAt(curW)) {
                            sb.append(park[i].charAt(curW));
                        } else {
                            sb.setLength(0);
                            break;
                        }
                    }

                    if(sb.length() > 0) {
                        curH -= distance;
                    }

                    break;
                default : break;
            }
        }

        return new int[]{curH, curW};
    }

    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        solution(park, routes);
    }
}
