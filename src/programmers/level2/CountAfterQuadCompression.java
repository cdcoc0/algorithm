package programmers.level2;

/**
 * 쿼드압축 후 개수 세기 (월간 코드 챌린지 시즌1)
 * comment : dfs/dp
 */
public class CountAfterQuadCompression {
    private int[] recursive(int[][] arr, int[] start, int size) {
        int a = start[0];
        int b = start[1];

        if(size > 1) {
            int[][] result = new int[4][2];
            result[0] = recursive(arr, new int[]{a, b}, size/2);
            result[1] = recursive(arr, new int[]{a, b+size/2}, size/2);
            result[2] = recursive(arr, new int[]{a+size/2, b}, size/2);
            result[3] = recursive(arr, new int[]{a+size/2, b+size/2}, size/2);

            if(result[0][0] == 0 && result[1][0] == 0 && result[2][0] == 0 && result[3][0] == 0) {
                return new int[]{0, 1};
            }

            if(result[0][1] == 0 && result[1][1] == 0 && result[2][1] == 0 && result[3][1] == 0) {
                return new int[]{1, 0};
            }

            return new int[]{result[0][0]+result[1][0]+result[2][0]+result[3][0], result[0][1]+result[1][1]+result[2][1]+result[3][1]};
        }

        int val = arr[start[0]][start[1]];
        return new int[] {val == 0 ? 1 : 0, val == 1 ? 1 : 0};
    }

    private int[] solution(int[][] arr) {
        return this.recursive(arr, new int[]{0, 0}, arr.length);
    }

    public static void main(String[] args) {
        CountAfterQuadCompression main = new  CountAfterQuadCompression();
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};

        int[] result = main.solution(arr);

        for(int r : result) {
            System.out.println(r);
        }
    }
}
