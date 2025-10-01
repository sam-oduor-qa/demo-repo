public class CalculatorMain {
    public static void main(String[] args) {
        InputHandler input = new InputHandler();
        boolean continueCalculating = true;

        System.out.println("===== Welcome to Calculator =====");
        System.out.println("Enter expressions like: 467-70, 900*4, 15.5+3.2, etc.\n");

        while (continueCalculating) {
            try {
                // Get expression from user
                String expression = input.getExpression();

                // Check for empty input
                if (expression.isEmpty()) {
                    System.out.println("Error: Please enter a valid expression.\n");
                    continue;
                }

                // Parse the expression
                ExpressionParser parser = new ExpressionParser(expression);
                
                if (!parser.parse()) {
                    System.out.println("Error: Invalid expression format. Please use format like: 10+5, 20-8, etc.\n");
                    continue;
                }

                double num1 = parser.getNum1();
                double num2 = parser.getNum2();
                String op = parser.getOperator();

                // Create appropriate operation object
                Operation operation;

                switch (op) {
                    case "+":
                        operation = new Addition(num1, num2);
                        break;
                    case "-":
                        operation = new Subtraction(num1, num2);
                        break;
                    case "*":
                        operation = new Multiplication(num1, num2);
                        break;
                    case "/":
                        operation = new Division(num1, num2);
                        break;
                    default:
                        System.out.println("Error: Invalid operation!\n");
                        continue;
                }

                // Execute and display result
                double result = operation.execute();
                
                // Format the output nicely
                System.out.println("\n" + expression + " = " + result);

            } catch (ArithmeticException e) {
                System.out.println("\nError: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nError: An unexpected error occurred. Please try again.");
                e.printStackTrace(); // For debugging
            }

            // Ask if user wants to continue
            continueCalculating = input.askToContinue();
            
            if (continueCalculating) {
                System.out.println("\n--- New Calculation ---\n");
            }
        }

        System.out.println("\nThank you for using Calculator. Goodbye!");
        input.close();
    }
}