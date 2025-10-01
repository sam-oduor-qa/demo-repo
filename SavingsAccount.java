public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String pin, double initialBalance) {
        super(accountNumber, pin, initialBalance);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
