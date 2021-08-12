package programmers.level1;

public class matrixAddition {
    static int[][] solution(int[][] arr1, int[][] arr2) {
//        int row = Math.max(arr1.length, arr2.length);
//        int col = Math.max(arr1[0].length, arr2[0].length);

        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};


    }
}
