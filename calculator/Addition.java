public class Addition extends Operation {
    public Addition(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public double execute() {
        return num1 + num2;
    }
}