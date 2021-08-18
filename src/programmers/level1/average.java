package programmers.level1;

public class average {
    static double avg(int[] arr) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double answer = (sum * 1.0) / arr.length;

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        System.out.println(avg(arr));
    }
}
