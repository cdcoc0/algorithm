package programmers.level2;

/* 3*n 타일링 */
public class x3xNTiling {
    private static int solution(int n) {
        int answer = 3;

        if(n % 2 == 1) {
            return 0;
        }

        int accumulated = 0;
        int prevValue = 0;

        for(int i = 4; i <= n; i += 2) {
            accumulated += 2 * prevValue;
            prevValue = answer;
            answer = (prevValue * 3 + 2 + accumulated) % 10000;
        }

        return answer;
    }



//    private static long solution(int n) {
//        long[] tile = new long[5001];
//
//        long answer = 0;
//        int mod=1000000007;
//
//        tile[0]=1;
//        tile[2]=3;
//
//        for(int i=4; i<=n; i+=2){
//            tile[i] = tile[i-2] * 3;
//            for(int j=i-4; j>=0; j-=2){
//                tile[i] += tile[j] * 2;
//            }
//            tile[i] = tile[i] % mod;
//        };
//
//        return answer=tile[n];
//    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
