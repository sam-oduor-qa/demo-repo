
public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, String pin, double initialBalance) {
        super(accountNumber, pin, initialBalance);
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
