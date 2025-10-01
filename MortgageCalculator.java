import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator implements MortgageCalculatorInterface {
    private int principal;
    private double interestRate;
    private int years;

    public MortgageCalculator(int principal, double interestRate, int years) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.years = years;
    }

     @Override
     public double calculateMonthlyPayment() {
         double monthlyRate = interestRate / 100 / 12;
         int numberOfPayments = years * 12;
         return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numberOfPayments));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        while (true) {
            System.out.print("Enter principal amount (1 - 1,000,000): ");
            String input = scanner.next();
            try {
                if (input.contains(",") || input.contains(".")) {
                    throw new NumberFormatException();
                }
                principal = Integer.parseInt(input);
                if (principal >= 1 && principal <= 1_000_000)
                    break;
                System.out.println("Error: Principal must be between 1 and 1,000,000.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a whole number without commas or decimals.");
            }
        }

        float annualInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate (>0 and <30, use dot as decimal separator, e.g., 3.33): ");
            String input = scanner.next();
            try {
                if (input.contains(",")) {
                    throw new NumberFormatException();
                }
                annualInterest = Float.parseFloat(input);
                if (annualInterest > 0 && annualInterest < 30)
                    break;
                System.out.println("Error: Annual interest rate must be greater than 0 and less than 30.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid decimal number using a dot (e.g., 3.33), not a comma.");
            }
        }
        float monthlyInterest = annualInterest / 100 / 12;

        byte years = 0;
        while (true) {
            System.out.print("Period (Years, whole number >0): ");
            String input = scanner.next();
            try {
                if (input.contains(",") || input.contains(".")) {
                    throw new NumberFormatException();
                }
                years = Byte.parseByte(input);
                if (years > 0)
                    break;
                System.out.println("Error: Number of years must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a whole number without commas or decimals.");
            }
        }
        int numberOfPayments = years * 12;

        // Step 5: Calculate Mortgage using the formula
        // M = P [ r(1 + r)^n ] / [ (1 + r)^n - 1 ]

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
        scanner.close();

    }

}
