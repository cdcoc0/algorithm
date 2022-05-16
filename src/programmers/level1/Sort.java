package programmers.level1;

public class Sort {
    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int[] tmp = new int[j - i + 1];

            int cnt = i - 1;
            for(int b = 0; b < j - i + 1; b++) {
                tmp[b] = array[cnt++];
            }

            //정렬
            for(int c = 0; c < tmp.length; c++) {
                for(int d = tmp.length - 1; d > c; d--) {
                    if(tmp[d] < tmp[d - 1]) {
                        swap(tmp, d, d - 1);
                    }
                }
            }

            answer[a] = tmp[k - 1];
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands)[0]);
        System.out.println(solution(array, commands)[1]);
        System.out.println(solution(array, commands)[2]);
    }
}
