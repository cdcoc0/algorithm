package programmers.level2;

import java.util.*;

/**
 * 수식 최대화 (2020 카카오 인턴십)
 * comment : 재귀 사용(경우의 수를 순열의 개념으로 접근), 자원을 좀더 아끼고 소스코드가 직관적이어야 할 것 같음
 */
public class MaximizeExpression {
    private List<String> splitExpressions(String expression) {
        List<String> split = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < expression.length(); i++) {
            char tmp = expression.charAt(i);
            if(tmp == '+' || tmp == '-' || tmp == '*') {
                split.add(sb.toString());
                split.add(String.valueOf(tmp));
                sb.setLength(0);
            } else {
                sb.append(tmp);
            }

            if(i == expression.length()-1) {
                split.add(sb.toString());
            }
        }

        return split;
    }

    private void getCalculates(List<String> splitExpressions, String processed, long[] result) {
        if(splitExpressions.size() == 1) {
            result[0] = Math.max(result[0], Math.abs(Long.parseLong(splitExpressions.get(0))));
            return;
        }

        final String PLUSIDX = "0";
        final String MINUSIDX = "1";
        final String MULTIPLYIDX = "2";

        final String PLUS = "+";
        final String MINUS = "-";
        final String MULTIPLY = "*";

        String firstNum = splitExpressions.get(0);
        List<String> pl = new ArrayList<>(Arrays.asList(firstNum));
        List<String> mi = new ArrayList<>(Arrays.asList(firstNum));
        List<String> mu = new ArrayList<>(Arrays.asList(firstNum));

        for(int i = 0; i < splitExpressions.size(); i++) {
            String tmp = splitExpressions.get(i);

            if (tmp.equals(PLUS) || tmp.equals(MINUS) || tmp.equals(MULTIPLY)) {
                String next = splitExpressions.get(i + 1);

                if (tmp.equals(PLUS)) {
                    pl.set(pl.size() - 1, String.valueOf(Long.parseLong(pl.get(pl.size() - 1)) + Long.parseLong(next)));
                } else {
                    pl.add(tmp);
                    pl.add(next);
                }

                if (tmp.equals(MINUS)) {
                    mi.set(mi.size() - 1, String.valueOf(Long.parseLong(mi.get(mi.size() - 1)) - Long.parseLong(next)));
                } else {
                    mi.add(tmp);
                    mi.add(next);
                }

                if (tmp.equals(MULTIPLY)) {
                    mu.set(mu.size() - 1, String.valueOf(Long.parseLong(mu.get(mu.size() - 1)) * Long.parseLong(next)));
                } else {
                    mu.add(tmp);
                    mu.add(next);
                }
            }
        }

        if(!processed.contains(PLUSIDX)) {
            this.getCalculates(pl, processed + PLUSIDX, result);
        }

        if(!processed.contains(MINUSIDX)) {
            this.getCalculates(mi, processed + MINUSIDX, result);
        }

        if(!processed.contains(MULTIPLYIDX)) {
            this.getCalculates(mu, processed + MULTIPLYIDX, result);
        }
    }

    private long solution(String expression) {
        long[] result = new long[1];
        List<String> split = this.splitExpressions(expression);

        this.getCalculates(split, "", result);

        return result[0];
    }

    public static void main(String[] args) {
        MaximizeExpression main = new MaximizeExpression();

//        String expression = "100-200*300-500+20";
        String expression = "50*6-3*2";
        System.out.println(main.solution(expression));
    }
}

