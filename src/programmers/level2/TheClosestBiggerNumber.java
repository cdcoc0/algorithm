package programmers.level2;

public class TheClosestBiggerNumber {
    static int solution(int n) {
        String binary = Integer.toBinaryString(n);
        // Integer.bitCount()

//        int cntOne = binary.replaceAll("[^1]", "").length();
        int cntOne = 0;
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') {
                cntOne++;
            }
        }

        while(true) {
            n++;

            String tmpBinary = Integer.toBinaryString(n);
            int tmpOne = 0;
            for(int i = 0; i < tmpBinary.length(); i++) {
                if(tmpBinary.charAt(i) == '1') {
                    tmpOne++;
                }
            }

            if(tmpOne == cntOne) {
                return n;
            }
        }

        //int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        //return n + postPattern | smallPattern;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}