import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getExpression() {
        System.out.print("Enter expression (e.g., 10+5, 20-8, 15*3, 100/4): ");
        return scanner.nextLine().trim();
    }

    public boolean askToContinue() {
        System.out.print("\nDo you want to perform another calculation? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();
        
        while (!response.equals("yes") && !response.equals("no") && 
               !response.equals("y") && !response.equals("n")) {
            System.out.println("Error: Please enter 'yes' or 'no'");
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            response = scanner.nextLine().trim().toLowerCase();
        }
        
        return response.equals("yes") || response.equals("y");
    }

    public void close() {
        scanner.close();
    }
}