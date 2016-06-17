public class ExpressionEvaluation {
    int evalParams(String expr, boolean result) {
        if (expr == null || expr.length() == 0)
            return 0;

        if (expr.length() == 1) { 		// operand

            if (expr.equals("1") && result)
                return 1;
            else if (expr.equals("0") && !result)
                return 1;
            else
                return 0;
        }

        int ways = 0;

        for (int i = 1; i < expr.length(); i+= 2) {
            String left = expr.substring(0, i);
            String right = expr.substring(i+1);

            int leftTrue = evalParams(left, true);
            int leftFalse = evalParams(left, false);
            int rightTrue = evalParams(right, true);
            int rightFalse = evalParams(right, false);

            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            char operator = expr.charAt(i);
            int totalTrue = 0;

            switch(operator) {
            case '&':
                totalTrue = leftTrue * rightTrue;
                break;
            case '|':
                totalTrue = leftTrue * rightTrue +
                            leftTrue * rightFalse +
                            leftFalse * rightTrue;
                break;
            case '^':
                totalTrue = leftTrue * rightFalse +
                            leftFalse * rightTrue;
                break;
            }

            if (result) {
                ways += totalTrue;
            } else {
                ways += (total - totalTrue);
            }
        }

        return ways;
    }



    public static void main(String[] args) {
        ExpressionEvaluation ee = new ExpressionEvaluation();
        System.out.println(ee.evalParams("1^0|0|1", false));
        System.out.println(ee.evalParams("0&0&0&1^1|0", true));
    }
}
