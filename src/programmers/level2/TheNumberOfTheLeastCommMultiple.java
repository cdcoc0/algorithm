package programmers.level2;

/* N개의 최소공배수 */
public class TheNumberOfTheLeastCommMultiple {
    private static int gcd(int a, int b) {
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }

    private static int solution(int[] arr) {
        int len = arr.length;
        if(len == 1) return arr[0];

        int lcm = arr[0];
        for(int i = 1; i < len; i++) {
            lcm = lcm * arr[i] / gcd(lcm, arr[i]);
        }

        return lcm;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(solution(arr));
    }
}
