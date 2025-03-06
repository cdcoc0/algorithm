package programmers.level2;

/* 행렬의 곱셈 */
public class MatrixMultiplication {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int height = arr1.length;
        int weight = arr2[0].length;
        int[][] answer = new int[height][weight];


        for(int i = 0; i < height; i++) {
            for(int j = 0; j < arr2.length; j++) {
                for(int k = 0; k < weight; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] arr2 = {{1, 4}, {2, 5}, {3, 6}};

//        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
//        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        MatrixMultiplication main = new MatrixMultiplication();
        main.solution(arr1, arr2);
    }
}
