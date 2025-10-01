public class App {
    private int principal;

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int principal = 0;
        while (true) {
            System.out.print("Enter principal amount (1 - 10,000,000): ");
            String input = scanner.nextLine();
            try {
                principal = Integer.parseInt(input);
                if (principal >= 1 && principal <= 10000000) {
                    break;
                } else {
                    System.out.println("Error: Principal must be between 1 and 10,000,000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer for principal.");
            }
        }

        double rate = 0.0;
        while (true) {
            System.out.print("Enter annual interest rate (e.g., 3.50): ");
            String input = scanner.nextLine();
            try {
                rate = Double.parseDouble(input);
                String[] parts = input.split("\\.");
                if (parts.length == 2 && parts[1].length() > 2) {
                    System.out.println("Error: Rate can have at most 2 decimal places.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for rate.");
            }
        }

        int years = 0;
        while (true) {
            System.out.print("Enter period (whole number of years): ");
            String input = scanner.nextLine();
            try {
                years = Integer.parseInt(input);
                if (years > 0) {
                    break;
                } else {
                    System.out.println("Error: Period must be a positive whole number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid whole number for period.");
            }
        }

        MortgageCalculator calculator = new MortgageCalculator(principal, rate, years);
        double monthlyPayment = calculator.calculateMonthlyPayment();

        java.text.NumberFormat currency = java.text.NumberFormat.getCurrencyInstance();
        String formattedPayment = currency.format(monthlyPayment);
        System.out.println("Monthly Payment: " + formattedPayment);

        scanner.close();
    }

    public int getPrincipal() { return principal; }
    public void setPrincipal(int principal) { this.principal = principal; }
}
