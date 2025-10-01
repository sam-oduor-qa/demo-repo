public class ExpressionParser {
    private String expression;
    private double num1;
    private double num2;
    private String operator;

    public ExpressionParser(String expression) {
        this.expression = expression.replaceAll("\\s+", ""); // Remove all whitespace
    }

    public boolean parse() {
        // Find the operator position
        int operatorIndex = -1;
        String ops = "+-*/";
        
        // Start from index 1 to handle negative numbers (e.g., -5+3)
        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (ops.indexOf(c) != -1) {
                operatorIndex = i;
                operator = String.valueOf(c);
                break;
            }
        }

        // Check if operator was found
        if (operatorIndex == -1) {
            return false;
        }

        // Extract numbers
        try {
            String num1Str = expression.substring(0, operatorIndex);
            String num2Str = expression.substring(operatorIndex + 1);

            // Check if parts are empty
            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                return false;
            }

            num1 = Double.parseDouble(num1Str);
            num2 = Double.parseDouble(num2Str);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

    public String getExpression() {
        return expression;
    }
}