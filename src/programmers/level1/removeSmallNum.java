package programmers.level1;

public class removeSmallNum {
    static int[] solution(int[] arr) {

        if(arr.length == 1) {
            return new int[]{-1};
        } else {
            int[] answer = new int[arr.length - 1];
            int index = 0;
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] < arr[index]) {
                    index = i;
                }
            }

            for(int i = 0; i < index; i++) {
                answer[i] = arr[i];
            }
            for(int i = index + 1; i < arr.length; i++) {
                answer[i - 1] = arr[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        solution(arr);
    }
}
