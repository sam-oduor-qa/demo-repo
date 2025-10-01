import java.util.Scanner;

public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");

        Account account = login(scanner);
        
        if (account == null) {
            System.out.println("Authentication failed.");
            scanner.close();
            return;
        }

        mainMenu(scanner, account);
        scanner.close();
    }

    private Account login(Scanner scanner) {
        // Account verification
        Account account = null;
        int attempts = 0;
        
        while (account == null && attempts < 3) {
            System.out.print("Enter account number: ");
            String accNum = scanner.nextLine();
            account = bank.getAccount(accNum);
            
            if (account == null) {
                attempts++;
                System.out.println("Account not found.");
                if (attempts < 3) {
                    System.out.println("Try again. Attempts remaining: " + (3 - attempts));
                }
            }
        }
        
        if (account == null) {
            return null;
        }
        
        // PIN verification
        attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();
            
            if (account.checkPin(pin)) {
                System.out.println("Login successful.");
                return account;
            } else {
                attempts++;
                System.out.println("Invalid PIN.");
                if (attempts < 3) {
                    System.out.println("Try again. Attempts remaining: " + (3 - attempts));
                }
            }
        }
        
        return null;
    }

    private void mainMenu(Scanner scanner, Account account) {
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    System.out.println("Balance: " + account.getBalance());
                    break;
                    
                case "2":
                    deposit(scanner, account);
                    break;
                    
                case "3":
                    withdraw(scanner, account);
                    break;
                    
                case "4":
                    System.out.println("Thank you for using the ATM!");
                    return;
                    
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void deposit(Scanner scanner, Account account) {
        while (true) {
            System.out.print("Enter deposit amount: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Try again.");
                    continue;
                }
                
                account.deposit(amount);
                System.out.println("Deposited. New balance: " + account.getBalance());
                break;
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void withdraw(Scanner scanner, Account account) {
        while (true) {
            System.out.print("Enter withdrawal amount: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Try again.");
                    continue;
                }
                
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawn. New balance: " + account.getBalance());
                    break;
                } else {
                    System.out.println("Insufficient funds or invalid amount. Try again.");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}