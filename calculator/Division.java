public class Division extends Operation {
    public Division(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double execute() {
        if (num2 == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}