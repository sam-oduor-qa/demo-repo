public abstract class Operation {
    protected double num1;
    protected double num2;

    public Operation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Abstract method to be implemented by subclasses
    public abstract double execute();
}