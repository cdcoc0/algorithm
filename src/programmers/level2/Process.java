package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 프로세스 */
public class Process {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int ptr = priorities.length - 1;

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            if(tmp[1] == priorities[ptr]) {
                if(tmp[0] == location) {
                    answer =  priorities.length - ptr;
                    break;
                }
                ptr--;
            } else {
                queue.offer(tmp);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Process main = new Process();

        int[] properties = {2, 1, 3, 2};
        int location = 2;
//        int[] properties = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        main.solution(properties, location);
    }
}
