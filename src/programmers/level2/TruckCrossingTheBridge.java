package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

/* 다리를 지나는 트럭 */
public class TruckCrossingTheBridge {
    private int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        int time = 0;
        for(int w : truck_weights) {
            if(queue.isEmpty()) {
                queue.offer(w);
                sum += w;
                time++;
            } else {
                while(true) {
                    if(queue.size() == bridge_length) {
                        int tmp = queue.poll();
                        sum -= tmp;
                    }

                    if(sum + w > weight) {
                        queue.offer(0);
                        time++;
                    } else {
                        queue.offer(w);
                        time++;
                        sum += w;
                        break;
                    }
                }
            }
        }

        return time + bridge_length;
    }

    public static void main(String[] args) {
        TruckCrossingTheBridge main = new TruckCrossingTheBridge();

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(main.solution(bridge_length, weight, truck_weights));
    }
}
