package programmers.level2;

/**
 * 삼각 달팽이 (월간 코드 챌린지 시즌1)
 * comment : 더 깔끔한 규칙을 찾으면 좋을 듯
 */
public class TriangleSnail {
    private int[] getVertexIndex(int[] vertex) {
        /**
         * 1 - 0
         * 2 - 4
         * 3 - 12
         * 4 - 24
         * 5 - 40
         */

        for(int i = 2; i < vertex.length; i++){
            vertex[i] = i * 2 * (i-1);
        }

        return vertex;
    }

    private int[] solution(int n) {
        // increasing : 0, 1, 3, 6
        // decreasing : 9, 5, 2
        // start : 0, 4, 12, 24 (홀수 줄의 중앙) -> 이전 줄까지의 개수 + 이전 줄/2

        if(n == 1) return new int[]{n};

        int cells = 1;
        for(int i = 2; i <= n; i++) {
            cells += i;
        }

        int[] answer = new int[cells];
        int[] vertex = getVertexIndex(new int[n/2+1]);
        int count = n;
        int vertexIndex = 1;
        int num = 1;

        while(count > 0) {
            int index = vertex[vertexIndex];

            answer[index] = num++;
            for(int i = count-1, j = vertexIndex*2-1; i > 0; i--) {
                index += j++;
                answer[index] = num++;
            }

            count--;
            if(count == 0) break;

            for(int i = count; i > 0; i--) {
                answer[++index] = num++;
            }

            count--;
            if(count == 0) break;

            for(int i = count, j = n-vertexIndex+1; i > 0; i--) {
                index -= j--;
                answer[index] = num++;
            }

            count--;
            vertexIndex++;
        }

        return answer;
    }

    public static void main(String[] args) {
        TriangleSnail main = new TriangleSnail();
//        main.solution(4);
//        main.solution(5);
        main.solution(1);
    }
}
