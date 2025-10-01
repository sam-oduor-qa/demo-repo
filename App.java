public class App {
    public static void main(String[] args) {
        // Demonstrate base class
        MortgageCalculator baseCalculator = new MortgageCalculator(200000, 3.5, 30);
        double baseMonthlyPayment = baseCalculator.calculateMonthlyPayment();
        System.out.println("Base Monthly Payment: " + baseMonthlyPayment);

        // Demonstrate inherited class
        AdvancedMortgageCalculator advancedCalculator = new AdvancedMortgageCalculator(200000, 3.5, 30, 100, 50);
        double advancedMonthlyPayment = advancedCalculator.calculateMonthlyPayment();
        System.out.println("Advanced Monthly Payment (with insurance & tax): " + advancedMonthlyPayment);
    }

    public int getPrincipal() { return principal; }
    public void setPrincipal(int principal) { this.principal = principal; }
}
