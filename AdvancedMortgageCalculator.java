public class AdvancedMortgageCalculator extends MortgageCalculator implements MortgageCalculatorInterface {
    private double insurance;
    private double propertyTax;

    public AdvancedMortgageCalculator(double principal, double annualInterestRate, int years, double insurance, double propertyTax) {
        super(principal, annualInterestRate, years);
        this.insurance = insurance;
        this.propertyTax = propertyTax;
    }

    @Override
    public double calculateMonthlyPayment() {
        double basePayment = super.calculateMonthlyPayment();
        // Add insurance and property tax to monthly payment
        return basePayment + insurance + propertyTax;
    }

    // Add more advanced features as needed

    public double getTotalPayment() {
        return calculateMonthlyPayment() * years * 12;
    }

    public static void main(String[] args) {
        AdvancedMortgageCalculator calc = new AdvancedMortgageCalculator(200000, 5, 30, 100, 200);
        System.out.println("Total Payment: " + calc.getTotalPayment());
    }
}

class MortgageCalculator {
    protected double principal;
    protected double annualInterestRate;
    protected int years;

    public MortgageCalculator(double principal, double annualInterestRate, int years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMonthlyPayment() {
        // Example calculation (monthly payment formula)
        double monthlyInterest = annualInterestRate / 12 / 100;
        int n = years * 12;
        return (principal * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -n));
    }
}