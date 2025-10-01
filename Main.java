
public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();
        
        // Add some sample accounts for testing
        Account checking = new CheckingAccount("12345", "1234", 1000.0);
        Account savings = new SavingsAccount("67890", "5678", 5000.0);
        
        bank.addAccount(checking);
        bank.addAccount(savings);
        
        // Start the ATM
        ATM atm = new ATM(bank);
        atm.start();
    }
}